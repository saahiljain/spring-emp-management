package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.beans.Employee;

public interface EmployeeRepository extends MongoRepository <Employee,Integer>
{}