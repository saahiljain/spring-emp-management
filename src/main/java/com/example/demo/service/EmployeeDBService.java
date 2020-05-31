package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.beans.Employee;
import com.example.demo.repo.EmployeeRepository;

@Component
public class EmployeeDBService {

	@Autowired
	private EmployeeRepository employeeRepository;
	


	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll(); 
	}



	public Employee insertEmployee(Employee employee) {
		
		return employeeRepository.insert(employee);
	}



	public Optional<Employee> getEmployeeById(Integer empId) {
		return employeeRepository.findById(empId);
	}



	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee); 
	}



	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(empId);
	}
	

}
