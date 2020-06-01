package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.beans.Address;
import com.example.demo.beans.Employee;

@Component
public class EmployeeService {
	

	public static  List<Employee> employees=new ArrayList <Employee>() ;
		// TODO Auto-generated method stub
		static {
			employees.add(new Employee(1,"a",1,"a@gmail.com",new Address("101", "mg road", "bangalore", "India")));	
			employees.add(new Employee(2,"b",2,"b@gmail.com",new Address("102", "brigade road", "bangalore", "India")));
			employees.add(new Employee(3,"c",3,"c@gmail.com",new Address("101", "food street", "bangalore", "India")));
	}
		
		
		
		public  List<Employee> getAllEmployees() {
			return employees;
		}



		public Employee saveEmployee(Employee employee) {
			// TODO Auto-generated method stub
			if(employee.getId()==0) {
				employee.setId(employees.size()+1);
			}
			employees.add(employee); 
			
			return employee; 
		}



		public Employee findOneEmployee(int empId) {
			// TODO Auto-generated method stub
			for(Employee emp : employees) {
				if(emp.getId() == empId) {
					return emp; 
				}
			}
			return null; 
		}
		

}
