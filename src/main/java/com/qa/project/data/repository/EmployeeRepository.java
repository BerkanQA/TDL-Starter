package com.qa.project.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.project.data.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByName(String name);
	
	@Query(value = "SELECT * FROM employee", nativeQuery = true)
	public List<Employee> getAllEmployeeSQL();
	
	@Query("SELECT d FROM Employee d")
	public List<Employee> getAllEmployeeJPQL();
	
	@Query("SELECT d FROM Employee d WHERE d.name =?1")
	public Employee getEmployeeByNameJPQL(String name);

}
