package com.deloitte.banking.model.dtos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class AccountDto {

	private Long accntId;

	private String accntType;

	private Date accntOpenDt;

	private BigDecimal accntBal;

	private MemberDto member;

	private List<LedgerDto> ldgrHstry;

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

	public MemberDto getMember() {
		return member;
	}

	public void setMember(MemberDto member) {
		this.member = member;
	}

	public List<LedgerDto> getLdgrHstry() {
		return ldgrHstry;
	}

	public void setLdgrHstry(List<LedgerDto> ldgrHstry) {
		this.ldgrHstry = ldgrHstry;
	}

	@Override
	public String toString() {
		return "AccountDto [accntId=" + accntId + ", accntType=" + accntType + ", accntOpenDt=" + accntOpenDt
				+ ", accntBal=" + accntBal + ", member=" + member + ", ldgrHstry=" + ldgrHstry + "]";
	}

}
