package com.prject.intern.project.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prject.intern.project.dto.EmployeeRequest;
import com.prject.intern.project.dto.EmployeeResponse;
import com.prject.intern.project.entity.Employee;
import com.prject.intern.project.exception.EmployeeIdNotFoundException;
import com.prject.intern.project.exception.NoEmployeeDataFoundException;
import com.prject.intern.project.repository.EmployeeRepository;


@Service("empService")
public class EmployeeServiceImplements implements EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) 
	{

		Employee employee = this.modelMapper.map(employeeRequest,Employee.class);

		employee = employeeRepository.save(employee);

		EmployeeResponse employeeResponse = this.modelMapper.map(employee, EmployeeResponse.class);


		return employeeResponse;

	}

	@Override
	public EmployeeResponse getEmployeeDetailsById(int employeeId) 
	{

		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

		if(optionalEmployee.isPresent()) 
		{

			Employee employee = optionalEmployee.get();

			EmployeeResponse employeeResponse = this.modelMapper.map(employee, EmployeeResponse.class);

			return employeeResponse;
		}
		throw new EmployeeIdNotFoundException("Employee Id Not Found");
	}

	@Override
	public List<EmployeeResponse> getAllEmployee() 
	{

		List<Employee> listEmployee = employeeRepository.findAll();

		if(listEmployee.isEmpty()) 
		{
			throw new NoEmployeeDataFoundException("No Data Found");
		}

		List<EmployeeResponse> listEmployeeResponse = new ArrayList<EmployeeResponse>();

		for(Employee employee:listEmployee) 
		{
			EmployeeResponse employeeResponse = this.modelMapper.map(employee, EmployeeResponse.class);
			listEmployeeResponse.add(employeeResponse);
		}
		return listEmployeeResponse;
	}

	@Override
	
	public EmployeeResponse updateEmployee(int employeeId,EmployeeRequest employeeRequest) 
	{

		Employee employee = this.modelMapper.map(employeeRequest, Employee.class);
		employee.setEmployeeId(employeeId);

		employee = employeeRepository.save(employee);
		EmployeeResponse employeeResponse = this.modelMapper.map(employee,EmployeeResponse.class);
		
		return employeeResponse;
		
	}

	@Override
	public String deleteEmployee(int employeeId) 
	{
		
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if(optionalEmployee.isPresent()) 
		{
			employeeRepository.deleteById(employeeId);
			return " Employee Deleted" ;
		}
		throw new NoEmployeeDataFoundException("No Data Found");

		
	}

	@Override
	public List<EmployeeResponse> getEmployeeDetailsByFirstName(String employeeFirstName) 
	{
		List<Employee> listEmployee = employeeRepository.findByFirstName(employeeFirstName);

		if(listEmployee.isEmpty()) 
		{
			throw new NoEmployeeDataFoundException("No Data Found");
		}

		List<EmployeeResponse> listEmployeeResponse = new ArrayList<EmployeeResponse>();

		for(Employee employee:listEmployee) 
		{
			EmployeeResponse employeeResponse = this.modelMapper.map(employee, EmployeeResponse.class);
			listEmployeeResponse.add(employeeResponse);
		}
		return listEmployeeResponse;
	}
		
	
}
