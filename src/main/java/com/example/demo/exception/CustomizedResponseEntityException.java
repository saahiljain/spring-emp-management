package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(final Exception ex,final WebRequest request) throws Exception{
		ex.printStackTrace();
		final ExceptionResponse exceptionResponse= new ExceptionResponse (new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
		@ExceptionHandler(EmployeeAlreadyExists.class)
		public final ResponseEntity<Object> handleEmployeeAlreadyExists(final Exception ex,final WebRequest request) throws Exception{
			ex.printStackTrace();
			final ExceptionResponse exceptionResponse= new ExceptionResponse (new Date(),ex.getMessage(),request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
		}
					
					@ExceptionHandler(EmployeeDoesNotException.class)
			public final ResponseEntity<Object> handleEmployeeDoesnotExists(final Exception ex,final WebRequest request) throws Exception{
				ex.printStackTrace();
				final ExceptionResponse exceptionResponse= new ExceptionResponse (new Date(),ex.getMessage(),request.getDescription(false));
				return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);			
						}
}
