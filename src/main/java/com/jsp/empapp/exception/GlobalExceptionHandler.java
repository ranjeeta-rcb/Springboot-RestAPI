package com.jsp.empapp.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String>handle (DataNotFoundException exception){
		return Map.of("error", exception.getMessage());
	}
	@ExceptionHandler(DataExistException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public Map<String,String>handle (DataExistException exception){
		return Map.of("error", exception.getMessage());
}
}