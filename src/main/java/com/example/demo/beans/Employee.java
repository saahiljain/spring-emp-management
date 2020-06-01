package com.example.demo.beans;


public class Employee {
	
	private int id;
	private String name;
	private int empAge;
	private String email;
	private Address address;
	
	public Employee(int id, String name, int empAge, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.empAge = empAge;
		this.email = email;
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empAge=" + empAge + ", email=" + email + ", address="
				+ address + "]";
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
