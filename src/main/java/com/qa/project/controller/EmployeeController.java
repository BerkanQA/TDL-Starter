package com.qa.project.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

// Adding a RestController to send back data in an http 
// Adding RequestMapping to have a base of /employee for this controller (localhost:8080/duck)

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	
	// injects from the application context
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
		
		HttpHeaders httpHeaders = new HttpHeaders(); //Creates Headers
		httpHeaders.add("Location", "1442"); // Adds a header
		
		return new ResponseEntity<List<EmployeeDTO>>(data,httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping	// retrieving 
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") int id) {
		// @pathvariable captures the path variable
		
		EmployeeDTO employee = employeeService.readById(id);
		
		return new ResponseEntity<EmployeeDTO>(employee, HttpStatus.OK);
	}
	
	@PostMapping // creating 
	public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody Employee employee) {
		
		EmployeeDTP newEmployee = employeeService.createEmployee(employee);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newEmployee.getId()));
		
		return new ResponseEntity<EmployeeDTO>(newEmployee, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}") //generalised update
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") int id,
													  @RequestBody Employee employee) {
		EmployeeDTO updateEmployee = employeeService.updateEmployee(id, employee);
		
		return new ResponseEntity<EmployeeDTO>(updatedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}") // Deletes
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") int id) {
		return new ResponseEntity<Boolean>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}
}
