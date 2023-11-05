package com.prject.intern.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse 
{
	private int employeeId;
	private String email;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String department;
	private String position;
	private double salary;
}
