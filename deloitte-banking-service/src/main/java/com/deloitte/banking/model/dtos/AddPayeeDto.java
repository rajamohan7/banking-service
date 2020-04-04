package com.deloitte.banking.model.dtos;

import java.io.Serializable;

public class AddPayeeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7522297734312549825L;

	private String mbrPanNbr;

	private Long mbrPyeAccNbr;

	private String mbrPyeName;

	public String getMbrPanNbr() {
		return mbrPanNbr;
	}

	public void setMbrPanNbr(String mbrPanNbr) {
		this.mbrPanNbr = mbrPanNbr;
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
