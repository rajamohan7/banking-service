package com.deloitte.banking.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deloitte.banking.model.entities.AccountEntity;
import com.deloitte.banking.model.entities.AccountPayeeEntity;
import com.deloitte.banking.model.entities.MemberEntity;

@Repository
public class BankingAccountRepositoryImpl implements BankingAccountRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public MemberEntity queryAccountsByPAN(String userPanNumber) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MemberEntity> cq = criteriaBuilder.createQuery(MemberEntity.class);
		Root<MemberEntity> root = cq.from(MemberEntity.class);

		Predicate predicate1 = criteriaBuilder.equal(root.get("panNbr"), userPanNumber);
		cq.select(root).where(predicate1);
		TypedQuery<MemberEntity> tq = entityManager.createQuery(cq);
		try {
			return tq.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public AccountEntity getAccoutInfo(Long accoutId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountEntity> cq = criteriaBuilder.createQuery(AccountEntity.class);
		Root<AccountEntity> root = cq.from(AccountEntity.class);

		Predicate predicate1 = criteriaBuilder.equal(root.get("accntId"), accoutId);
		cq.select(root).where(predicate1);
		TypedQuery<AccountEntity> tq = entityManager.createQuery(cq);
		try {
			return tq.getSingleResult();
		} catch (NoResultException e) { 
			return null;
		}
	}
	
	@Override
	public void mergePayees(AccountPayeeEntity payeeEntity) {
		entityManager.persist(payeeEntity); 
	}
	
	@Override
	public void saveMember(MemberEntity member) {
		entityManager.persist(member); 
	}
	
	@Override
	public void saveAccount(AccountEntity account) {
		entityManager.persist(account); 
	} 

	@Override
	public void saveTransaction(AccountEntity account) {
		entityManager.merge(account); 		
	}

}
