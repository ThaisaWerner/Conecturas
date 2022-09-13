package com.tw.spring.exception;

<<<<<<< HEAD
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.exception.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.validation.*;
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = DefaultException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(DefaultException e){
		
		return new ResponseEntity<ErrorResponse>(e.getErrorResponse(),e.httpStatus);
	}
	
	
<<<<<<< HEAD
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldNome = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldNome, message);
		});
		
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex, WebRequest webRequest){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("Este usuário já está cadastrado");
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		
	}
=======
	
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
	
	
}
