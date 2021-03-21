package com.qa.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.project.data.model.Employee;
import com.qa.project.dto.EmployeeDTO;
import com.qa.project.service.EmployeeService;

// Adding a RestController to send back data in an http 
// Adding RequestMapping to have a base of /employee for this controller (localhost:8080/employee)

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

	private EmployeeService employeeService;

	// injects from the application context

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping // retrieving
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") int id) {

		EmployeeDTO employee = employeeService.readById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {

		HttpHeaders httpHeaders = new HttpHeaders(); // Creates Headers
		httpHeaders.add("Location", "1442"); // Adds a header
		List<EmployeeDTO> employee = employeeService.readAllEmployees();
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/{id}") // creating
	public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody Employee employee) {

		EmployeeDTO newEmployee = employeeService.createEmployee(employee);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newEmployee.getId()));

		return new ResponseEntity<EmployeeDTO>(newEmployee, headers, HttpStatus.CREATED);
	}

	@PutMapping("/{id}") // generalised update
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employee);	
		return new ResponseEntity<EmployeeDTO>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}") // Deletes
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") int id) {
		return new ResponseEntity<Boolean>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}
}
