package com.deloitte.banking.service;

import javax.transaction.Transactional;

import com.deloitte.banking.model.dtos.UserInputRequest;
import com.deloitte.banking.model.dtos.UserOutputResponse;
import com.deloitte.banking.model.entities.MemberEntity;

public interface MemberAcctService {

	MemberEntity getAllAccounts(UserInputRequest inputRequest);

	UserOutputResponse saveMemberDetails(UserInputRequest inputRequest);

	UserOutputResponse addPayee(UserInputRequest inputRequest);

}