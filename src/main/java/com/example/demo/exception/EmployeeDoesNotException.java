package com.example.demo.exception;

public class EmployeeDoesNotException extends RuntimeException {
	final private String message;

	public EmployeeDoesNotException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message; 
	} 
}