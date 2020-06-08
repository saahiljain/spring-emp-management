package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.beans.Employee;
import com.example.demo.beans.Salary;
import com.example.demo.service.EmployeeDBService;
import reactor.core.publisher.Mono;
//import org.json.simple.JSONObject;


@RestController
public class EmployeeDBController {
	
	@Autowired
	private EmployeeDBService employeeService;
	
	
	@GetMapping("/db/emps")
	public List<Employee> getAllEmployees(){
		
		final List<Employee> emps=employeeService.getAllEmployees();
		return emps;
		
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
	
	@GetMapping("/db/emps/age/{empAge}")
	public List<Employee> getEmployeeGreaterThanAge(@PathVariable int empAge){
			return employeeService.getEmployeesByAge(empAge); 
	}
}
