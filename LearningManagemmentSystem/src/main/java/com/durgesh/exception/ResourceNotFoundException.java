package com.durgesh.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}
	public ResourceNotFoundException() {
		
	}
	

}
