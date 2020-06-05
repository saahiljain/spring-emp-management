package com.example.demo.service;


import java.util.List;
import java.util.Optional;


import com.example.demo.beans.Employee;


public interface EmployeeService {
	

	public List<Employee> getAllEmployees();



	public Employee insertEmployee(Employee employee);



	public Optional<Employee> getEmployeeById(Integer empId);



	public Employee updateEmployee(Employee employee);



	public void deleteEmployee(int empId);
	


	public List<Employee> getEmployeesByAge(int empAge);
		

}