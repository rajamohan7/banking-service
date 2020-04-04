package com.deloitte.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.banking.model.dtos.TransactionDto;
import com.deloitte.banking.model.dtos.UserInputRequest;
import com.deloitte.banking.model.dtos.UserOutputResponse;
import com.deloitte.banking.model.entities.AccountEntity;
import com.deloitte.banking.model.entities.MemberEntity;
import com.deloitte.banking.service.MemberAcctService;
import com.deloitte.banking.service.SavingsAccountServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class BankingAccountController {

	@Autowired
	private MemberAcctService bankingAccountServiceImpl;

	@Autowired
	private SavingsAccountServiceImpl savingsAccountServiceImpl;

	@PostMapping(value = "/open-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserOutputResponse openAccount(@RequestBody UserInputRequest inputRequest) {
		return bankingAccountServiceImpl.saveMemberDetails(inputRequest);
	}

	@PostMapping(value = "/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
	public MemberEntity dashboard(@RequestBody UserInputRequest inputRequest) {
		MemberEntity memberRecord = bankingAccountServiceImpl.getAllAccounts(inputRequest);
		memberRecord.setUserName(null);
		memberRecord.setPassword(null);
		return memberRecord;
	}

	@PostMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountEntity transfer(@RequestBody TransactionDto transactionDto) {

		AccountEntity account = savingsAccountServiceImpl.getAccountInfo(transactionDto.getAccntId());
		if (account == null)
			return null;

		if (account.getAccntType().equalsIgnoreCase("Savings") || account.getAccntType().equalsIgnoreCase("Salary")) {

			if (transactionDto.getTransactionType().equalsIgnoreCase("Credit")) {
				return savingsAccountServiceImpl.deposit(transactionDto, account);
			}
			if (transactionDto.getTransactionType().equalsIgnoreCase("Debit")
					|| transactionDto.getTransactionType().equalsIgnoreCase("Transfer")) {
				savingsAccountServiceImpl.withdraw(transactionDto, account);
			}
		}
		return null;
	}

	@PostMapping(value = "/add-payee", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserOutputResponse addPayee(@RequestBody UserInputRequest inputRequest) {
		return bankingAccountServiceImpl.addPayee(inputRequest);
	}

	@PostMapping(value = "/tx-history", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccountEntity> transactionsHistory(@RequestBody UserInputRequest inputRequest) {
		return null;
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccountEntity> login(@RequestBody UserInputRequest inputRequest) {
		return null;
	}

	@PostMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccountEntity> logout(@RequestBody UserInputRequest inputRequest) {
		return null;
	}
}