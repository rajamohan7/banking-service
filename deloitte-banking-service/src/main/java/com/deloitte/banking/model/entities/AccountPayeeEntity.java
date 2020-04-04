package com.deloitte.banking.model.entities;

import java.io.Serializable;

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
@Table(name = "MBR_ACT_PYE")
public class AccountPayeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -285047897460995262L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MBR_ACT_PYE_ID", updatable = false, unique = true, nullable = false)
	private Long mbrActPyeId;

	@JsonBackReference
	@JoinColumn(name = "MBR_ID", nullable = false)
	@ManyToOne
	private MemberEntity member;

	@Column(name = "MBR_PYE_ACT_NBR", nullable = false)
	private Long mbrPyeAccNbr;

	@Column(name = "MBR_PYE_NAME")
	private String mbrPyeName;

	public Long getMbrActPyeId() {
		return mbrActPyeId;
	}

	public void setMbrActPyeId(Long mbrActPyeId) {
		this.mbrActPyeId = mbrActPyeId;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
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

	@Override
	public String toString() {
		return "AccountPayeeEntity [mbrPyeAccNbr=" + mbrPyeAccNbr + ", mbrPyeName=" + mbrPyeName + "]";
	}

}
