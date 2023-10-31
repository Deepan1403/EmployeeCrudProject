 package com.prject.intern.project.service;

import org.springframework.stereotype.Service;

import com.prject.intern.project.dto.EmployeeDTO;

@Service
public interface EmployeeService
{
	public EmployeeDTO getEmployeeDetails(int employeeId);
	
	public String addEmployee(EmployeeDTO empDTO);
	
	public String updateEmployee(EmployeeDTO empDTO);
	
	public String deleteEmployee(int employeeId);
	
	public EmployeeDTO getEmployeeDetailsByName(String employeeName);
	
}
