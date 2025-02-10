package com.bankingworkflowapp.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2978478961636291654L;

	public InvalidUserCredentialsException(String message) {
		super(message);
	}

}
