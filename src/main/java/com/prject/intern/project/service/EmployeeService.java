 package com.prject.intern.project.service;

import org.springframework.stereotype.Service;

import com.prject.intern.project.dto.EmployeeRequestDTO;
import com.prject.intern.project.dto.EmployeeResponseDTO;

@Service
public interface EmployeeService
{
	public EmployeeResponseDTO getEmployeeDetails(int employeeId);
	
	public String addEmployee(EmployeeRequestDTO empDTO);
	
	public String updateEmployee(EmployeeRequestDTO empDTO);
	
	public String deleteEmployee(int employeeId);
	
	public EmployeeResponseDTO getEmployeeDetailsByName(String employeeName);
	
}
