package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Employee;
import com.example.demo.service.EmployeeDBService;

@RestController
public class EmployeeDBController {
	
	@Autowired
	private EmployeeDBService employeeService;
	
	@GetMapping("/db/emps")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees(); 
	}
	
	@PostMapping("/db/emps")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee); 
	}
	
	@GetMapping("/db/emps/{empId}")
	public Optional<Employee> getEmployee(@PathVariable int empId) {
		return employeeService.getEmployeeById(empId); 
	}
	
	@PutMapping("/db/emps")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee); 
	}
	
	@DeleteMapping("/db/emps/{empId}")
	public void deleteEmployee(@PathVariable int empId) {
		employeeService.deleteEmployee(empId);
	}
}
