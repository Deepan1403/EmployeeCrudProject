package com.prject.intern.project.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prject.intern.project.dto.EmployeeDTO;
import com.prject.intern.project.entity.Employee;
import com.prject.intern.project.repository.EmployeeRepository;

@Service("empService")
public class EmployeeServiceImplements implements EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO getEmployeeDetails(int employeeId) {
		
		Optional<Employee> emp=employeeRepository.findById(employeeId);
		Employee empEntity = emp.get();
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setFirstName(empEntity.getFirstName());
		empDTO.setLastName(empEntity.getLastName());
		empDTO.setDOB(empEntity.getDOB());
		empDTO.setEmailId(empEntity.getEmailId());
		empDTO.setDepartment(empEntity.getDepartment());
		empDTO.setPosition(empEntity.getPosition());
		empDTO.setSalary(empEntity.getSalary());
		return null;
	}

	@Transactional
	@Override
	public String addEmployee(EmployeeDTO empDTO) {
		Employee emp = new Employee();
		//System.out.println(emp.getEmployeeId());
		emp.setFirstName(empDTO.getFirstName());
		emp.setLastName(empDTO.getLastName());
		emp.setDOB(empDTO.getDOB());
		emp.setEmailId(empDTO.getEmailId());
		emp.setDepartment(empDTO.getDepartment());
		emp.setPosition(empDTO.getPosition() );
		emp.setSalary(empDTO.getSalary());
		employeeRepository.save(emp);
		
	return "EMPLOYEE ADDED SUCCESSFULLY";
	}

	@Transactional
	@Override
	public String updateEmployee(EmployeeDTO empDTO) {
		
		Optional<Employee> opt =employeeRepository.findById(empDTO.getEmployeeId());
		Employee emp  = opt.get();
		emp.setFirstName(empDTO.getFirstName());
		emp.setLastName(empDTO.getLastName());
		emp.setDOB(empDTO.getDOB());
		emp.setEmailId(empDTO.getEmailId());
		emp.setDepartment(empDTO.getDepartment());
		emp.setPosition(empDTO.getPosition());
		emp.setSalary(empDTO.getSalary());
		employeeRepository.save(emp);
		return "UPDATE SUCCESS";
	}

	@Override
	public String deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		
		return null;
	}

	@Override
	public EmployeeDTO getEmployeeDetailsByName(String employeeName) {
		
		Employee emp = employeeRepository.findByFirstName(employeeName);
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setFirstName(emp.getFirstName());
		empDTO.setLastName(emp.getLastName());
		empDTO.setDOB(emp.getDOB());
		empDTO.setEmailId(emp.getEmailId());
		empDTO.setDepartment(emp.getDepartment());
		empDTO.setPosition(emp.getPosition());
		empDTO.setSalary(emp.getSalary());
		employeeRepository.delete(emp);
		return empDTO;
	}

}
