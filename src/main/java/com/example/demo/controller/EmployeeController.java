package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Employee;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	@GetMapping("/emps")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
		
	}
	
	@GetMapping("/emps/{empId}")
	public HttpEntity<Employee> getEmployee(@PathVariable int empId) throws UserNotFoundException {

		Employee employee = employeeService.findOneEmployee(empId);

		if (employee == null) {
			throw new UserNotFoundException("Sorry User Not Found");
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@PostMapping("/emps")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
}
