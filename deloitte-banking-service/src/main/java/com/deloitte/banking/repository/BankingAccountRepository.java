package com.deloitte.banking.repository;

import com.deloitte.banking.model.entities.AccountEntity;
import com.deloitte.banking.model.entities.AccountPayeeEntity;
import com.deloitte.banking.model.entities.MemberEntity;

public interface BankingAccountRepository {

	MemberEntity queryAccountsByPAN(String userPanNumber);

	AccountEntity getAccoutInfo(Long accoutId);

	void mergePayees(AccountPayeeEntity payeeEntity);

	void saveMember(MemberEntity member);

	void saveAccount(AccountEntity account);

	void saveTransaction(AccountEntity account);

}