package com.deloitte.banking.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.deloitte.banking.exceptions.DuplicateEntryException;
import com.deloitte.banking.exceptions.NoAccountFoundException;
import com.deloitte.banking.model.dtos.Error;
import com.deloitte.banking.model.dtos.UserInputRequest;
import com.deloitte.banking.model.dtos.UserOutputResponse;
import com.deloitte.banking.model.entities.AccountEntity;
import com.deloitte.banking.model.entities.AccountPayeeEntity;
import com.deloitte.banking.model.entities.LedgerEntity;
import com.deloitte.banking.model.entities.MemberEntity;
import com.deloitte.banking.repository.BankingAccountRepository;

@Service
public class MemberAcctServiceImpl implements MemberAcctService {

	@Autowired
	private BankingAccountRepository bankingAccountRepositoryImpl;

	@Override
	public MemberEntity getAllAccounts(UserInputRequest inputRequest) {
		return bankingAccountRepositoryImpl.queryAccountsByPAN(inputRequest.getPanNbr());
	}

	@Override
	@Transactional
	public UserOutputResponse saveMemberDetails(UserInputRequest inputRequest) {
		MemberEntity member = bankingAccountRepositoryImpl.queryAccountsByPAN(inputRequest.getPanNbr());

		UserOutputResponse response = new UserOutputResponse();
		if (member == null) {
			// Insert Member Record
			member = populateMemberRecord(inputRequest);
			bankingAccountRepositoryImpl.saveMember(member);
			System.out.println(member);
		} else if (member != null && member.getAccounts().stream()
				.noneMatch(acc -> acc.getAccntType().equalsIgnoreCase(inputRequest.getAccountType()))) {
			// Insert the Account only
			AccountEntity account = popualteOtherAccount(inputRequest, member);
			bankingAccountRepositoryImpl.saveAccount(account);
		} else {
			// Prompt saying the Account is already existed
			throw new DuplicateEntryException("PAN Number already associated to another account");
		}
		return prepareResponse(inputRequest, member, response);

	}

	@Override
	@Transactional
	public UserOutputResponse addPayee(UserInputRequest inputRequest) {
		MemberEntity member = bankingAccountRepositoryImpl.queryAccountsByPAN(inputRequest.getPanNbr());
		UserOutputResponse response = new UserOutputResponse();
		if (member == null) {
			// Prepare Error
			throw new NoAccountFoundException("Create at least one account before adding Payee.");
		}

		List<AccountPayeeEntity> payeeList = member.getPayees();

		if (payeeList.stream().anyMatch(payee -> payee.getMbrPyeName().equalsIgnoreCase(inputRequest.getMbrPyeName())
				&& payee.getMbrPyeAccNbr().equals(inputRequest.getMbrPyeAccNbr()))) {
			// Account Payee already exists
			
			throw new DuplicateEntryException("Account Payee already exist. Add other Payee.");
		}

		if (!StringUtils.isEmpty(inputRequest.getMbrPyeName())
				&& !StringUtils.isEmpty(inputRequest.getMbrPyeAccNbr())) {

			AccountPayeeEntity payeeEntity = new AccountPayeeEntity();
			payeeEntity.setMember(member);
			payeeEntity.setMbrPyeAccNbr(inputRequest.getMbrPyeAccNbr());
			payeeEntity.setMbrPyeName(inputRequest.getMbrPyeName());
			// member.setPayees(payeeList);
			bankingAccountRepositoryImpl.mergePayees(payeeEntity);
		} else {
			Error error = new Error();
			error.setErrorCode(103);
			error.setErrorMessage("Mandatory field(s) is(are) missing from request");
			error.setType("Business Error");
			response.addError(error);
		}
		return prepareResponse(inputRequest, member, response);
	}

	private UserOutputResponse prepareResponse(UserInputRequest inputRequest, MemberEntity member,
			UserOutputResponse response) {
		response.setAccountType(inputRequest.getAccountType());
		response.setMemberId(member.getMbrId());
		response.setFirstName(inputRequest.getFirstName());
		response.setLastName(inputRequest.getLastName());
		response.setPanNbr(inputRequest.getPanNbr());
		return response;
	}

	private AccountEntity popualteOtherAccount(UserInputRequest inputRequest, MemberEntity member) {
		AccountEntity account = new AccountEntity();
		account.setAccntOpenDt(new java.sql.Date(new java.util.Date().getTime()));
		account.setAccntType(inputRequest.getAccountType());
		account.setAccntBal(inputRequest.getMonthlySal());
		account.setLstUpdtd(new java.sql.Timestamp(new java.util.Date().getTime()));
		account.setMember(member);
		LedgerEntity ledger = new LedgerEntity();
		ledger.setTranxnAmt(inputRequest.getMonthlySal());
		ledger.setTranxnStatus("Success");
		ledger.setTranxnDt(new java.sql.Date(new java.util.Date().getTime()));
		ledger.setTranxnType("Credit");
		ledger.setAccount(account);

		List<LedgerEntity> ledgers = new ArrayList<>();
		ledgers.add(ledger);
		account.setLdgrHstry(ledgers);

		return account;
	}

	private MemberEntity populateMemberRecord(UserInputRequest inputRequest) {
		MemberEntity memberRecord = new MemberEntity();
		memberRecord.setFrstName(inputRequest.getFirstName());
		memberRecord.setLstName(inputRequest.getLastName());
		// memberRecord.setEmailAddr(inputRequest.get);
		memberRecord.setPanNbr(inputRequest.getPanNbr());
		memberRecord.setDateOfBirth(new java.sql.Date(inputRequest.getDateOfBirth().getTime()));
		// memberRecord.setUserName(userName);

		AccountEntity account = new AccountEntity();
		account.setAccntOpenDt(new java.sql.Date(new java.util.Date().getTime()));
		account.setAccntType(inputRequest.getAccountType());
		account.setAccntBal(inputRequest.getMonthlySal());
		account.setLstUpdtd(new java.sql.Timestamp(new java.util.Date().getTime()));
		List<AccountEntity> accounts = new ArrayList<>();
		accounts.add(account);
		LedgerEntity ledger = new LedgerEntity();
		ledger.setTranxnAmt(inputRequest.getMonthlySal());
		ledger.setTranxnStatus("Success");
		ledger.setTranxnDt(new java.sql.Date(new java.util.Date().getTime()));
		ledger.setTranxnType("Credit");
		ledger.setAccount(account);

		List<LedgerEntity> ledgers = new ArrayList<>();
		ledgers.add(ledger);
		account.setLdgrHstry(ledgers);
		account.setMember(memberRecord);
		memberRecord.setAccounts(accounts);
		return memberRecord;
	}

}
