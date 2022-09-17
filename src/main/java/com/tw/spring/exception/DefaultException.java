package com.tw.spring.exception;

import org.springframework.http.HttpStatus;

public class DefaultException extends RuntimeException {


    private static final long serialVersionUID = 1L;
    public HttpStatus httpStatus;
    public String message;

    public DefaultException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ErrorResponse getErrorResponse() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(String.valueOf(httpStatus.value()));
        errorResponse.setMessage(this.message);
        return errorResponse;
    }

}
