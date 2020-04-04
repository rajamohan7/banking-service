package com.deloitte.banking.model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "MBR_RCD")
public class MemberEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3086888248726622008L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @SequenceGenerator(name = "MBR_ID_SEQ", sequenceName = "MBR_ID_SEQ",
	// allocationSize = 1)
	@Column(name = "MBR_ID", updatable = false, unique = true, nullable = false)
	private Long mbrId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FRST_NAME", nullable = false)
	private String frstName;

	@Column(name = "LST_NAME", nullable = false)
	private String lstName;

	@Column(name = "DT_OF_BIRTH", nullable = false)
	private Date dateOfBirth;

	@Column(name = "PAN_NBR", nullable = false)
	private String panNbr;

	@Column(name = "MBR_ADDR")
	private String mbrAddr;

	@Column(name = "MOBILE_NBR")
	private String mobileNbr;

	@Column(name = "EMAIL_ADDR")
	private String emailAddr;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member", orphanRemoval = true)
	private List<AccountEntity> accounts;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member", orphanRemoval = true)
	private List<AccountPayeeEntity> payees;

	public Long getMbrId() {
		return mbrId;
	}

	public void setMbrId(Long mbrId) {
		this.mbrId = mbrId;
	}

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

	public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	public List<AccountPayeeEntity> getPayees() {
		return payees;
	}

	public void setPayees(List<AccountPayeeEntity> payees) {
		this.payees = payees;
	}

	@Override
	public String toString() {
		return "MemberEntity [mbrId=" + mbrId + ", frstName=" + frstName + ", lstName=" + lstName + ", dateOfBirth="
				+ dateOfBirth + ", panNbr=" + panNbr + "]";
	}

}
