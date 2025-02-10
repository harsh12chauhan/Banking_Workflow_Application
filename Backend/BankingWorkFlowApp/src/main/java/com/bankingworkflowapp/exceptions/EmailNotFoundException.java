package com.bankingworkflowapp.exceptions;

public class EmailNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4783348475542465838L;

	public EmailNotFoundException(String message) {
		super(message);
	}

}
