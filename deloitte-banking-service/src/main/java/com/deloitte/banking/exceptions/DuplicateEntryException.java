package com.deloitte.banking.exceptions;

public class DuplicateEntryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 106476501468135246L;
	
	public DuplicateEntryException(String msg) {
		super(msg);
	}

}
