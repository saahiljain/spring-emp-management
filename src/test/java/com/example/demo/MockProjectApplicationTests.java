package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.Address;
import com.example.demo.beans.Employee;
import com.example.demo.controller.EmployeeDBController;
import com.example.demo.service.EmployeeDBService;

@SpringBootTest
public class MockProjectApplicationTests {

	@InjectMocks
	EmployeeDBController employeeController;
	
	@Mock
	EmployeeDBService employeeServiceImpl;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllEmployeesTest() {
		final List<Employee > e = new ArrayList<Employee>();
		final Employee e1=new Employee(1,"saahil",20,"saahil@gmail.com",new Address("301-d","mgroad","bangalore","India"));
		final Employee e2=new Employee(2,"piyush",18,"piyush@gmail.com",new Address("301-d","mgroad","bangalore","India"));
		
		e.add(e1);
		e.add(e2);
		
		when(this.employeeServiceImpl.getAllEmployees()).thenReturn(e);
		
		final List<Employee> allEmployee =this.employeeController.getAllEmployees();
		assertEquals(2, allEmployee.size());
		verify(this.employeeServiceImpl).getAllEmployees();
		
	}
	
	@Test
	public void insertEmployeeTest()
	{
		final Employee e1=new Employee(1,"saahil",20,"saahil@gmail.com",new Address("301-d","mgroad","bangalore","India"));
		when(this.employeeServiceImpl.insertEmployee(e1)).thenReturn(e1);
		final Employee e =this.employeeController.saveEmployee(e1);
		verify(this.employeeServiceImpl).insertEmployee(e1);
		
	}
	
	@Test
	public void updateEmployeeTest()
	{
		final Employee e1=new Employee(1,"saahil",20,"saahil@gmail.com",new Address("301-d","mgroad","bangalore","India"));
		final Employee e =this.employeeController.saveEmployee(e1);
		
		e1.setName("test");
		
		when(this.employeeServiceImpl.updateEmployee(e1)).thenReturn(e1);
		final Employee e2=this.employeeController.updateEmployee(e1);
		verify(this.employeeServiceImpl).updateEmployee(e1);
		
		
	}
	
//	



}