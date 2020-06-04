package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeDoesNotException extends RuntimeException {
	private String message;

	public EmployeeDoesNotException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message; 
	} 
}
