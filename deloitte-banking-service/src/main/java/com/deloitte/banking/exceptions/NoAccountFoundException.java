package com.deloitte.banking.exceptions;

public class NoAccountFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4382355407126318472L;

	public NoAccountFoundException(String msg) {
		super(msg);
	}
}
