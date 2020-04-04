package com.deloitte.banking.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.banking.exceptions.InsufficientBalanceException;
import com.deloitte.banking.model.dtos.TransactionDto;
import com.deloitte.banking.model.entities.AccountEntity;
import com.deloitte.banking.model.entities.LedgerEntity;
import com.deloitte.banking.repository.BankingAccountRepository;

@Service
public class SavingsAccountServiceImpl implements CoreAccountService {

	@Autowired
	private BankingAccountRepository bankingAccountRepositoryImpl;

	public AccountEntity getAccountInfo(Long accountId) {
		return bankingAccountRepositoryImpl.getAccoutInfo(accountId);
	}

	@Override
	@Transactional
	public AccountEntity deposit(TransactionDto transactionDto, AccountEntity account) {

		LedgerEntity transaction = new LedgerEntity();
		transaction.setTranxnType(transactionDto.getTransactionType());
		transaction.setTranxnAmt(transactionDto.getTransactionAmt());
		transaction.setTranxnStatus("Success");
		transaction.setTranxnDt(new java.sql.Date(new java.util.Date().getTime()));
		transaction.setRemarks(transactionDto.getRemarks() + "; Deposited: " + transactionDto.getTransactionAmt());
		transaction.setAccount(account);
		account.setAccntBal(account.getAccntBal().add(transactionDto.getTransactionAmt()));
		account.setLstUpdtd(new java.sql.Timestamp(new java.util.Date().getTime()));
		account.getLdgrHstry().add(transaction);

		bankingAccountRepositoryImpl.saveTransaction(account);
		return account;
	}

	@Override
	public AccountEntity withdraw(TransactionDto transactionDto, AccountEntity account) {

		BigDecimal amount = account.getAccntBal().subtract(transactionDto.getTransactionAmt());
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			// Error - insufficient balance - throw exception
			throw new InsufficientBalanceException("Insufficient Balance");
		} else {
			LedgerEntity transaction = new LedgerEntity();
			transaction.setTranxnType(transactionDto.getTransactionType());
			transaction.setTranxnAmt(transactionDto.getTransactionAmt());
			transaction.setTranxnStatus("Success");
			transaction.setTranxnDt(new java.sql.Date(new java.util.Date().getTime()));
			transaction.setRemarks(transactionDto.getRemarks() + "; " + transactionDto.getTransactionType() + ":"
					+ transactionDto.getTransactionAmt());
			transaction.setAccount(account);
			account.setAccntBal(amount);
			account.setLstUpdtd(new java.sql.Timestamp(new java.util.Date().getTime()));
			account.getLdgrHstry().add(transaction);
			bankingAccountRepositoryImpl.saveTransaction(account);
			return account;
		}
	}
}
