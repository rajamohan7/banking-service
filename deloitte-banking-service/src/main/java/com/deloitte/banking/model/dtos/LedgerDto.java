package com.deloitte.banking.model.dtos;

import java.sql.Date;

public class LedgerDto {

	private Long tranxnId;

	private String tranxnType;

	private String tranxnAmt;

	private String tranxnStatus;

	private Date tranxnDt;
	
	private String remarks;

	private AccountDto account;

	public Long getTranxnId() {
		return tranxnId;
	}

	public void setTranxnId(Long tranxnId) {
		this.tranxnId = tranxnId;
	}

	public String getTranxnType() {
		return tranxnType;
	}

	public void setTranxnType(String tranxnType) {
		this.tranxnType = tranxnType;
	}

	public String getTranxnAmt() {
		return tranxnAmt;
	}

	public void setTranxnAmt(String tranxnAmt) {
		this.tranxnAmt = tranxnAmt;
	}

	public String getTranxnStatus() {
		return tranxnStatus;
	}

	public void setTranxnStatus(String tranxnStatus) {
		this.tranxnStatus = tranxnStatus;
	}

	public Date getTranxnDt() {
		return tranxnDt;
	}

	public void setTranxnDt(Date tranxnDt) {
		this.tranxnDt = tranxnDt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "LedgerDto [tranxnId=" + tranxnId + ", tranxnType=" + tranxnType + ", tranxnAmt=" + tranxnAmt
				+ ", tranxnStatus=" + tranxnStatus + ", tranxnDt=" + tranxnDt + ", account=" + account + "]";
	}

}
