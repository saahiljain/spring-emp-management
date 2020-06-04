package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository <Employee,Integer>
{

	@Query(value="{'empAge':{$gt:?0}}",
			fields = "{'empName':1, 'empAge':1, 'email':1, 'address.street':1}")
		List<Employee> findByAge(int empAge); 
}