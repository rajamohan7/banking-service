package com.deloitte.banking.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "MBR_ACT_LDGR")
public class LedgerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1780252966590240864L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @SequenceGenerator(name = "TRANXN_ID_SEQ", sequenceName = "TRANXN_ID_SEQ",
	// allocationSize = 1)
	@Column(name = "TRANXN_ID", updatable = false, unique = true, nullable = false)
	private Long tranxnId;

	@Column(name = "TRANXN_TYPE", nullable = false)
	private String tranxnType;

	@Column(name = "TRANXN_AMT", nullable = false)
	private BigDecimal tranxnAmt;

	@Column(name = "TRANXN_STATUS", nullable = false)
	private String tranxnStatus;

	@Column(name = "TRANXN_DT", nullable = false)
	private Date tranxnDt;
	
	@Column(name = "REMRKS")
	private String remarks;

	@JsonBackReference
	@JoinColumn(name = "ACCNT_ID", nullable = false)
	@ManyToOne
	private AccountEntity account;

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

	public BigDecimal getTranxnAmt() {
		return tranxnAmt;
	}

	public void setTranxnAmt(BigDecimal tranxnAmt) {
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

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "LedgerEntity [tranxnType=" + tranxnType + ", tranxnAmt=" + tranxnAmt + ", tranxnStatus=" + tranxnStatus
				+ ", tranxnDt=" + tranxnDt + "]";
	}

}
