package com.example.demo.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(
    		final Date timeStamp,
            final String message,
            final String details) 
    
    {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(final Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(final String details) {
        this.details = details;
    }
}
