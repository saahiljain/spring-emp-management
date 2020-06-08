package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Address;
import com.example.demo.beans.Employee;


public interface EmployeeService {
	

	public List<Employee> getAllEmployees();



	public Employee insertEmployee(Employee employee);



	public Optional<Employee> getEmployeeById(Integer empId) throws JSONException;



	public Employee updateEmployee(Employee employee);



	public void deleteEmployee(int empId);
	


	public List<Employee> getEmployeesByAge(int empAge);
		

}
