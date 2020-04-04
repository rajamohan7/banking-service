package com.deloitte.banking.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "MBR_ACT")
public class AccountEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -14766673694513780L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @SequenceGenerator(name = "ACCNT_ID_SEQ", sequenceName = "ACCNT_ID_SEQ", allocationSize = 1)
	@Column(name = "ACCNT_ID", updatable = false, unique = true, nullable = false)
	private Long accntId;

	@Column(name = "ACCNT_TYPE", nullable = false)
	private String accntType;

	@Column(name = "ACCNT_OPEN_DT", nullable = false)
	private Date accntOpenDt;

	@Column(name = "ACCNT_BAL", nullable = false)
	private BigDecimal accntBal;

	@JsonBackReference
	@JoinColumn(name = "MBR_ID", nullable = false)
	@ManyToOne
	private MemberEntity member;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account", orphanRemoval = true)
	private List<LedgerEntity> ldgrHstry;

	@Column(name = "LST_UPDTD_TS")
	private Timestamp lstUpdtd;

	public Long getAccntId() {
		return accntId;
	}

	public void setAccntId(Long accntId) {
		this.accntId = accntId;
	}

	public String getAccntType() {
		return accntType;
	}

	public void setAccntType(String accntType) {
		this.accntType = accntType;
	}

	public Date getAccntOpenDt() {
		return accntOpenDt;
	}

	public void setAccntOpenDt(Date accntOpenDt) {
		this.accntOpenDt = accntOpenDt;
	}

	public BigDecimal getAccntBal() {
		return accntBal;
	}

	public void setAccntBal(BigDecimal accntBal) {
		this.accntBal = accntBal;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	public List<LedgerEntity> getLdgrHstry() {
		return ldgrHstry;
	}

	public void setLdgrHstry(List<LedgerEntity> ldgrHstry) {
		this.ldgrHstry = ldgrHstry;
	}

	public Timestamp getLstUpdtd() {
		return lstUpdtd;
	}

	public void setLstUpdtd(Timestamp lstUpdtd) {
		this.lstUpdtd = lstUpdtd;
	}

	@Override
	public String toString() {
		return "AccountEntity [accntType=" + accntType + ", accntOpenDt=" + accntOpenDt + ", accntBal=" + accntBal
				+ "]";
	}

}
