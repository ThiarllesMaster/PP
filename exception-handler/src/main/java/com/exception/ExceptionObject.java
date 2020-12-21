package com.exception;

import org.springframework.http.HttpStatus;

public class ExceptionObject {

	private String message;
	private String detailMessage;
	private HttpStatus httpStatus;
	private Integer errorCode;
	
	
	public ExceptionObject(String message, String detailMessage, HttpStatus httpStatus, Integer errorCode) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.detailMessage = detailMessage;
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetailMessage() {
		return detailMessage;
	}
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}		
	
}
