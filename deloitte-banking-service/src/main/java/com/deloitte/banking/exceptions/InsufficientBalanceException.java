package com.deloitte.banking.exceptions;

public class InsufficientBalanceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4127587754869762883L;

	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}
