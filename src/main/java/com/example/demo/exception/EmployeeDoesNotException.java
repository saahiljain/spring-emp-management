package com.example.demo.exception;



//@ResponseStatus(HttpStatus.BAD_REQUEST)
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
