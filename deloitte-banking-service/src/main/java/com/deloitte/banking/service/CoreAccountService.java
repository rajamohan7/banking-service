package com.deloitte.banking.service;

import javax.transaction.Transactional;

import com.deloitte.banking.model.dtos.TransactionDto;
import com.deloitte.banking.model.entities.AccountEntity;

public interface CoreAccountService {

	AccountEntity deposit(TransactionDto transactionDto, AccountEntity account);

	AccountEntity withdraw(TransactionDto transactionDto, AccountEntity account);

}