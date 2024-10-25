package com.durgesh.exception;

public class CourseNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public CourseNotFoundException(String message) {
		super();
		this.message = message;
	}
	public CourseNotFoundException() {
		
	}
	

}
