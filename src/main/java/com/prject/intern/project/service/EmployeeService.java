 package com.prject.intern.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prject.intern.project.dto.EmployeeRequest;
import com.prject.intern.project.dto.EmployeeResponse;


@Service
public interface EmployeeService
{
	
	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest);
	
	public EmployeeResponse getEmployeeDetailsById(int employeeId);
	
	public List<EmployeeResponse> getAllEmployee();
	
	public EmployeeResponse updateEmployee(int employeeId,EmployeeRequest employeeRequest);
	
	public String deleteEmployee(int employeeId);
	
	public List<EmployeeResponse> getEmployeeDetailsByFirstName(String employeeFirstName);
	
}
