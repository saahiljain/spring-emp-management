package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeDBService implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll(); 
	}


	@Override
	public Employee insertEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public Optional<Employee> getEmployeeById(Integer empId) {
		return employeeRepository.findById(empId);
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee); 
	}


	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(empId);
	}



//	@Override
//	public List<Employee> getEmployeesByAge(int empAge) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

	@Override
	public List<Employee> getEmployeesByAge(int empAge) {
		// TODO Auto-generated method stub
		return employeeRepository.findByAge(empAge); 
	}

}
