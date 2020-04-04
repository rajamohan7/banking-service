package com.deloitte.banking.model.dtos;

import java.io.Serializable;

public class Error implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -275134637972446211L;

	private Integer errorCode;

	private String errorMessage;

	private String type;

	private StackTraceElement stackTrace;

	private Integer statusCd;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public StackTraceElement getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(StackTraceElement stackTrace) {
		this.stackTrace = stackTrace;
	}

	public Integer getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(Integer statusCd) {
		this.statusCd = statusCd;
	}

}
