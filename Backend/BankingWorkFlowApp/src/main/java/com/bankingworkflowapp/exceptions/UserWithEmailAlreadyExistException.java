package com.bankingworkflowapp.exceptions;

public class UserWithEmailAlreadyExistException extends RuntimeException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2519664004379582827L;

	public UserWithEmailAlreadyExistException(String message) {
		super(message);
	}

}
