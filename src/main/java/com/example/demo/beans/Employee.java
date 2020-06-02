package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Employee")
public class Employee {
	@javax.persistence.Id
	@Column(name="ID")
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="empAge")
	private int empAge;
	@Column(name="email")
	private String email;
	
	public Employee(int id, String name, int empAge, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.empAge = empAge;
		this.email = email;
		
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empAge=" + empAge + ", email=" + email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpAge() {
		return empAge;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
