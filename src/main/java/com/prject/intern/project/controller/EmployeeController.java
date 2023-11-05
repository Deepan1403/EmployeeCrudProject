package com.prject.intern.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prject.intern.project.dto.EmployeeRequest;
import com.prject.intern.project.dto.EmployeeResponse;
import com.prject.intern.project.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("adduser")
	public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest)
	{
		EmployeeResponse employeeResponse = employeeService.addEmployee(employeeRequest);
		return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.CREATED);
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@RequestParam int employeeId) 
	{
		EmployeeResponse employeeResponse = employeeService.getEmployeeDetailsById(employeeId);
		return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.FOUND);
	}
	
	@GetMapping("alldata")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee()
	{
		List<EmployeeResponse> listEmployeeResponse = employeeService.getAllEmployee();
		return new ResponseEntity<List<EmployeeResponse>>(listEmployeeResponse,HttpStatus.FOUND);
	}
	
	@PatchMapping("update")
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestParam int employeeId,@RequestBody EmployeeRequest employeeRequest) 
	{
		EmployeeResponse employeeResponse = employeeService.updateEmployee(employeeId, employeeRequest);
		return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
	}
	
	
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteEmplyee(@RequestParam int employeeId) 
	{
		String message = employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("getbyfirstname")
	public ResponseEntity<List<EmployeeResponse>> getEmployeeDetailsByName(@RequestParam String employeeFirstName) 
	{
		List<EmployeeResponse> employeeResponse = employeeService.getEmployeeDetailsByFirstName(employeeFirstName);
		return new ResponseEntity<List<EmployeeResponse>>(employeeResponse,HttpStatus.FOUND);
	}

}
