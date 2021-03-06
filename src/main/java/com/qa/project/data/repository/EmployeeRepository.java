package com.qa.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.project.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	

	
	@Query("SELECT e FROM employee e WHERE id = ?1")
	public Employee getEmployeeByNameJPQL(String name);
}
