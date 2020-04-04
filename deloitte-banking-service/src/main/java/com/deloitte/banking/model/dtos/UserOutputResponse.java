package com.deloitte.banking.model.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserOutputResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4714096905071827664L;

	private Long memberId;

	private String firstName;

	private String lastName;

	private String panNbr;

	private String accountType;
	
	private List<Error> errors = new ArrayList<>();

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPanNbr() {
		return panNbr;
	}

	public void setPanNbr(String panNbr) {
		this.panNbr = panNbr;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void addError(Error error) {
		this.errors.add(error);
	}

}
