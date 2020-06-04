package com.example.demo.service;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;
import com.example.demo.exception.EmployeeAlreadyExists;
import com.example.demo.exception.EmployeeDoesNotException;
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
	public Employee insertEmployee(Employee employee)  {
		final List<Employee> employees=employeeRepository.findAll();
		final Boolean idexists=employees.stream().anyMatch(e->e.getId()==(employee.getId()));
		if(Boolean.TRUE.equals(idexists)) {
			throw new EmployeeAlreadyExists("Employee Already Exists");
		}
		
		return employeeRepository.insert(employee);
	}


	@Override
	public Optional<Employee> getEmployeeById(Integer empId) {
		
		Optional<Employee> employee=employeeRepository.findById(empId);
		System.out.println(employee);
		if(employee.isPresent()) {
			return employee;
			
		}
		else {
			throw new EmployeeDoesNotException("Employee Does not exist in the DataBase");
		}
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
	
	@Override
	public List<Employee> getEmployeesByAge(int empAge)
	{
		return employeeRepository.findByAge(empAge);
	}

}
