package com.prject.intern.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApplicationExcepttionHandler {

	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler
	public ResponseEntity<String> employeeIdNotFoundException(EmployeeIdNotFoundException exception)
	{
		String s=exception.getMessage();
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> employeeNameNotFoundException(EmployeeNameNotFoundException exception)
	{
		String s=exception.getMessage();
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
}
