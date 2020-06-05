package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExists extends RuntimeException {
		final private String message;

		public EmployeeAlreadyExists(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return this.message; 
		} 
	
}