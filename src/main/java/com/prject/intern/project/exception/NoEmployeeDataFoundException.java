package com.prject.intern.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class NoEmployeeDataFoundException extends RuntimeException
{
	String message;
}
