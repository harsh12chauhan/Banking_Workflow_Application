package com.bankingworkflowapp.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6348826385201636782L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
