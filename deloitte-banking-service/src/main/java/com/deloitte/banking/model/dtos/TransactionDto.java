package com.deloitte.banking.model.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransactionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7607407060520644210L;

	private Long accntId;

	private String transactionType;

	private BigDecimal transactionAmt;

	private String transactionStatus;

	private String payeeName;
	
	private String remarks;

	public Long getAccntId() {
		return accntId;
	}

	public void setAccntId(Long accntId) {
		this.accntId = accntId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(BigDecimal transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
