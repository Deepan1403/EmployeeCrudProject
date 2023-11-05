package com.prject.intern.project.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prject.intern.project.dto.EmployeeResponse;
import com.prject.intern.project.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	public List<Employee> findByFirstName(String employeeFirstName);

}
