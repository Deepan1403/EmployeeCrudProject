package com.prject.intern.project.exception;

public class EmployeeIdNotFoundException extends RuntimeException
{
String message;
	
	public EmployeeIdNotFoundException(String message) 
	{
		this.message=message;
	}
	public String getMessage(){
		return message;
	}
}
