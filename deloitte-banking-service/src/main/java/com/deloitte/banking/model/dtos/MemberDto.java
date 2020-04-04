package com.deloitte.banking.model.dtos;

import java.math.BigInteger;
import java.util.List;

public class MemberDto {

	private Long mbrId;

	private BigInteger userName;

	private String password;

	private String frstName;

	private String lstName;

	private String panNbr;

	private String mbrAddr;

	private String mobileNbr;

	private String emailAddr;

	private List<AccountDto> accounts;

	public Long getMbrId() {
		return mbrId;
	}

	public void setMbrId(Long mbrId) {
		this.mbrId = mbrId;
	}

	public BigInteger getUserName() {
		return userName;
	}

	public void setUserName(BigInteger userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFrstName() {
		return frstName;
	}

	public void setFrstName(String frstName) {
		this.frstName = frstName;
	}

	public String getLstName() {
		return lstName;
	}

	public void setLstName(String lstName) {
		this.lstName = lstName;
	}

	public String getPanNbr() {
		return panNbr;
	}

	public void setPanNbr(String panNbr) {
		this.panNbr = panNbr;
	}

	public String getMbrAddr() {
		return mbrAddr;
	}

	public void setMbrAddr(String mbrAddr) {
		this.mbrAddr = mbrAddr;
	}

	public String getMobileNbr() {
		return mobileNbr;
	}

	public void setMobileNbr(String mobileNbr) {
		this.mobileNbr = mobileNbr;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public List<AccountDto> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDto> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "MemberDto [mbrId=" + mbrId + ", frstName=" + frstName + ", lstName=" + lstName + ", panNbr=" + panNbr
				+ ", mbrAddr=" + mbrAddr + ", mobileNbr=" + mobileNbr + ", emailAddr=" + emailAddr + ", accounts="
				+ accounts + "]";
	}

}
