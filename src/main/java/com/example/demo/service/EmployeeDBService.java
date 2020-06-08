package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.beans.Employee;
import com.example.demo.beans.Salary;
import com.example.demo.exception.EmployeeAlreadyExists;
import com.example.demo.exception.EmployeeDoesNotException;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeDBService implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll(); 
	}


	@Override
	public Employee insertEmployee(Employee employee) {
		final List<Employee> employees=employeeRepository.findAll();
		final Boolean idexists=employees.stream().anyMatch(e->e.getId()==(employee.getId()));
		if(Boolean.TRUE.equals(idexists)) {
			throw new EmployeeAlreadyExists("Employee Already Exists");
		}
		
		
		return employeeRepository.save(employee);
	}


	@Override
	public Optional<Employee> getEmployeeById(Integer empId) {
		Optional<Employee> employee=employeeRepository.findById(empId);
		System.err.println(employee);
		if(employee.isPresent()) {
			System.out.println("http://localhost:8100/db/salary/"+employee.get().getId());
			Salary s=webClientBuilder.build().get().uri("http://localhost:8100/db/salary/"+employee.get().getId()).retrieve().bodyToMono(Salary.class).block();
			System.err.println("saahil");
			System.out.println("web-client-output"+s);
			JSONObject obj=new JSONObject();
//			obj.put("Employee",employee);
//			obj.put("Salary",s);
			return employee;
			
		}
		else {
			throw new EmployeeDoesNotException("Employee Does not exist in the DataBase");
		}
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee); 
	}
	@Override
	public void deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
	}
	@Override
	public List<Employee> getEmployeesByAge(int empAge) {
		return employeeRepository.findByAge(empAge); 
	}

}
