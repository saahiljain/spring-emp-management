package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.beans.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>
{
	@Query("select e from Employee e where e.empAge>:empAge")
	List<Employee> findByAge(@Param("empAge") int empAge);
}