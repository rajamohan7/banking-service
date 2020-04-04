package com.deloitte.banking.model.dtos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class UserInputRequest {

	private String userName;

	private String password;

	private BigInteger memberId;

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private String panNbr;

	private BigDecimal monthlySal;

	private String accountType;

	private Long mbrPyeAccNbr;

	private String mbrPyeName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getMemberId() {
		return memberId;
	}

	public void setMemberId(BigInteger memberId) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNbr() {
		return panNbr;
	}

	public void setPanNbr(String panNbr) {
		this.panNbr = panNbr;
	}

	public BigDecimal getMonthlySal() {
		return monthlySal;
	}

	public void setMonthlySal(BigDecimal monthlySal) {
		this.monthlySal = monthlySal;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getMbrPyeAccNbr() {
		return mbrPyeAccNbr;
	}

	public void setMbrPyeAccNbr(Long mbrPyeAccNbr) {
		this.mbrPyeAccNbr = mbrPyeAccNbr;
	}

	public String getMbrPyeName() {
		return mbrPyeName;
	}

	public void setMbrPyeName(String mbrPyeName) {
		this.mbrPyeName = mbrPyeName;
	}

}
