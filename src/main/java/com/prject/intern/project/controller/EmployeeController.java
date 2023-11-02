package com.prject.intern.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prject.intern.project.dto.EmployeeRequestDTO;
import com.prject.intern.project.dto.EmployeeResponseDTO;
import com.prject.intern.project.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService empService;
	@CrossOrigin
	@PostMapping("/newuser")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequestDTO empDTO) 
	{
		String emp=empService.addEmployee(empDTO);
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
		
	}
	@CrossOrigin
	@GetMapping("/get")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeDetails(@RequestParam int employeeId) 
	{
		
		return new ResponseEntity<>(empService.getEmployeeDetails(employeeId),HttpStatus.OK);
		
	}
	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRequestDTO empDTO) 
	{
		return new ResponseEntity<>(empService.updateEmployee(empDTO),HttpStatus.OK);
		
	}
	@CrossOrigin
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmplyee(@RequestParam int employeeId) 
	{
		return new ResponseEntity<>(empService.deleteEmployee(employeeId),HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("firstname")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeDetailsByName(@RequestParam String firstName) 
	{
		
		return  new ResponseEntity<>(empService.getEmployeeDetailsByName(firstName),HttpStatus.OK);
	}

}
