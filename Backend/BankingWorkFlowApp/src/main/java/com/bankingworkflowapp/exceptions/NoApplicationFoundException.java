package com.bankingworkflowapp.exceptions;

public class NoApplicationFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4375483822290314730L;
	
	public NoApplicationFoundException(String message) {
		super(message);
	}
	
}
