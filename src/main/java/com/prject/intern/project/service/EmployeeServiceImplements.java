package com.prject.intern.project.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prject.intern.project.dto.EmployeeRequestDTO;
import com.prject.intern.project.dto.EmployeeResponseDTO;
import com.prject.intern.project.entity.Employee;
import com.prject.intern.project.exception.EmployeeIdNotFoundException;
import com.prject.intern.project.repository.EmployeeRepository;

@Service("empService")
public class EmployeeServiceImplements implements EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponseDTO getEmployeeDetails(int employeeId)
	{
		
		Optional<Employee> optionalEmployee =employeeRepository.findById(employeeId);
	    if(optionalEmployee.isPresent())
	    {
	    	throw new EmployeeIdNotFoundException("Employee Not Found");
	    }
		Employee empEntity = optionalEmployee.get();
		EmployeeResponseDTO empDTO = new EmployeeResponseDTO();
		empDTO.setFirstName(empEntity.getFirstName());
		empDTO.setLastName(empEntity.getLastName());
		empDTO.setDOB(empEntity.getdOB());
		empDTO.setEmailId(empEntity.getEmailId());
		empDTO.setDepartment(empEntity.getDepartment());
		empDTO.setPosition(empEntity.getPosition());
		empDTO.setSalary(empEntity.getSalary());
		return empDTO;
	}

	@Transactional
	@Override
	public String addEmployee(EmployeeRequestDTO empReqDTO) 
	{
		Employee emp = new Employee();
		emp.setFirstName(empReqDTO.getFirstName());
		emp.setLastName(empReqDTO.getLastName());
		emp.setDOB(empReqDTO.getdOB());
		emp.setEmailId(empReqDTO.getEmailId());
		emp.setDepartment(empReqDTO.getDepartment());
		emp.setPosition(empReqDTO.getPosition() );
		emp.setSalary(empReqDTO.getSalary());
		emp=employeeRepository.save(emp);
		
	return "EMPLOYEE ADDED SUCCESSFULLY";
	}

	@Transactional
	@Override
	public String updateEmployee(EmployeeRequestDTO empReqDTO) 
	{
		
		Optional<Employee> opt =employeeRepository.findById(empReqDTO.getEmployeeId());
		Employee emp  = opt.get();
		emp.setFirstName(empReqDTO.getFirstName());
		emp.setLastName(empReqDTO.getLastName());
		emp.setDOB(empReqDTO.getdOB());
		emp.setEmailId(empReqDTO.getEmailId());
		emp.setDepartment(empReqDTO.getDepartment());
		emp.setPosition(empReqDTO.getPosition());
		emp.setSalary(empReqDTO.getSalary());
		employeeRepository.save(emp);
		return "UPDATE SUCCESS";
	}

	@Override
	public String deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		
		return null;
	}

	@Override
	public EmployeeResponseDTO getEmployeeDetailsByName(String employeeName) 
	{
		
		Employee emp = employeeRepository.findByFirstName(employeeName);
		if(emp==null)
		{
			throw new EmployeeIdNotFoundException("Employee Not Found");
		}
		
		EmployeeResponseDTO empDTO = new EmployeeResponseDTO();
		empDTO.setFirstName(emp.getFirstName());
		empDTO.setLastName(emp.getLastName());
		empDTO.setDOB(emp.getdOB());
		empDTO.setEmailId(emp.getEmailId());
		empDTO.setDepartment(emp.getDepartment());
		empDTO.setPosition(emp.getPosition());
		empDTO.setSalary(emp.getSalary());
		employeeRepository.delete(emp);
		return empDTO;
	}
}
