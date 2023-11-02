package com.prject.intern.project.dto;


import javax.persistence.Entity;
import javax.persistence.Id;

public class EmployeeRequestDTO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String dOB;
	private String emailId;
	private String department;
	private String position;
	private double salary;
	
	
    public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployyeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getdOB() {
		return dOB;
	}
	public void setDOB(String dOB) {
		System.out.println(dOB);
		this.dOB = dOB;
		
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", dOB="
				+ dOB + ", emailId=" + emailId + ", department=" + department + ", position=" + position + ", salary="
				+ salary + "]";
	}
	
	

}
