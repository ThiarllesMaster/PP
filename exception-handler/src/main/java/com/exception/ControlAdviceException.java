package com.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControlAdviceException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {Exception.class })
	public final ResponseEntity<ExceptionObject[]> handleException(Exception e ) {
		
		StringBuilder detailMessage = new StringBuilder();
		detailMessage.append(e.getCause().getClass().toString());
		detailMessage.append(":");
		detailMessage.append(e.getCause().getMessage());
		
		ExceptionObject[] exc = {new ExceptionObject(e.getLocalizedMessage(), detailMessage.toString(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value())};
		
		return new ResponseEntity<ExceptionObject[]>(exc, HttpStatus.BAD_REQUEST);
	}
	
		
	@Override
    protected  ResponseEntity<Object>  handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       
        StringBuilder errors = new StringBuilder();
               
        for (ObjectError error: ex.getBindingResult().getAllErrors()) {
        	errors.append(error.getDefaultMessage());
        }
        
        ExceptionObject[] exc = {new ExceptionObject(errors.toString(), ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value())};

        return new ResponseEntity<>(exc, HttpStatus.BAD_REQUEST);
    }
}
