package com.prject.intern.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prject.intern.project.dto.EmployeeDTO;
import com.prject.intern.project.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/newuser")
	public String addEmployee(@RequestBody EmployeeDTO empDTO)
	{
		return empService.addEmployee(empDTO) ;
	}
	
	@GetMapping("{employeeId}")
	public EmployeeDTO getEmployeeDetails(@PathVariable int employeeId)
	{
		
		return empService.getEmployeeDetails(employeeId);
		
	}
	@PutMapping("update")
	public String updateEmployee(@RequestBody EmployeeDTO empDTO)
	{
		return empService.updateEmployee(empDTO);
		
	}
	
	@DeleteMapping("delete/{employeeId}")
	public String deleteEmplyee(@PathVariable int employeeId)
	{
		return empService.deleteEmployee(employeeId);
	}
	
	@GetMapping("firstname/{employeeName}")
	public EmployeeDTO getEmployeeDetailsByName(@PathVariable String firstName)
	{
		
		return empService.getEmployeeDetailsByName(firstName);
	}

}

// pathvariable to requestparam
