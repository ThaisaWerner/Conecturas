package com.tw.spring.exception;

import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class DefaultException extends RuntimeException implements Supplier<DefaultException>{

	 
	private static final long serialVersionUID = 1L;
	public HttpStatus httpStatus;
	public String message;
	
	public DefaultException(HttpStatus httpStatus,String message) {
		 this.httpStatus = httpStatus;
		 this.message=message;
	}
	
	public DefaultException() {}
	
	@Override
	public DefaultException get() {
		// TODO Auto-generated method stub
		return this;
	} 
	
	public ErrorResponse getErrorResponse()	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(String.valueOf(httpStatus.value()));
		errorResponse.setMessage(this.message);
		return errorResponse;
	}
	  
 
}
