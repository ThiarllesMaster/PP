package com.exception;

public class StudentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentException(String message, Throwable err) {
		super(message, err);
	}

}
