package com.prject.intern.project.exception;

public class EmployeeNameNotFoundException extends RuntimeException
{
	String message;
	
	public EmployeeNameNotFoundException(String message)
	{
		this.message=message;
	}
	public String getMessage(){
		return message;
	}

}
