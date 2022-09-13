package com.tw.spring.exception;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse implements Serializable {

 	private static final long serialVersionUID = 1L;
 	
 	private String code;
 	private String message;
 	private String detail;
<<<<<<< HEAD
 	
	//public ErrorResponse(Date date, String string, String description) {
		// TODO Auto-generated constructor stub
	//}
=======
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
 	
 	

}
