package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.project.data.model.Employee;
import com.qa.project.dto.EmployeeDTO;
import com.qa.project.mappers.EmployeeMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // configures the MockMvc object (used to send requests to our API)
@Sql(scripts = { "classpath:test-schema.sql", "classpath:test-data.sql" },
	 executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class EmployeeControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Employee validEmployee = new Employee(1, "test", "test1", "test2", 0);
	private EmployeeDTO employeeDTO = new EmployeeDTO(1, "test", "test1", "test2");
	
	private List<Employee> validEmployees = List.of(validEmployee);
	private List<EmployeeDTO> validEmployeeDTOs = List.of(employeeDTO);
	
	@Test
	public void createEmployeeTest() throws Exception {
		Employee employeeToSave = new Employee();
	}
}
