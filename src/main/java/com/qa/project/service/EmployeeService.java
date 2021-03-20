package com.qa.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qa.project.data.model.Employee;
import com.qa.project.data.repository.EmployeeRepository;
import com.qa.project.dto.EmployeeDTO;
import com.qa.project.exceptions.EmployeeNotFoundException;
import com.qa.project.mappers.EmployeeMapper;


@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	private EmployeeMapper employeeMapper;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}
	
	public List<EmployeeDTO> readAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		List<Employee> employeeDTOs = new ArrayList<EmployeeDTO>();
		
		employees.forEach(employee -> employeeDTOs.add(employeeMapper.mapToDTO(Employee))); 
		
		return employeeDTOs;
	}
	
	public EmployeeDTO readById(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employeeMapper.maptoDTO(employee.get());
		} else {
			throw new EmployeeNotFoundException("Employee not found");
		}
	}
	public EmployeeDTO readByName(String name) {
		Employee employee = employeeRepository.getEmployeeByNameJPQL(name);
		
		return employeeMapper.maptoDTO(employee);
		
	}
	
	public EmployeeDTO updateEmployee(Integer id, Employee employee) throws EntityNotFoundException {
		Optional<Employee> employeeInDbOpt = employeeRepository.findById(id);
		Employee EmployeeInDb;
		
		if (employeeInDbOpt.isPresent()) {
			employeesInDb = employeeInDbOpt.get();
		} else {
			throw new EmployeeNotFoundException("Employee is not here, QUACK!");
		}
		
		employeeInDb.setName(employee.getName());
		employeeInDb.setAge(employee.getAge());
		employeeInDb.setHabitat(employee.getLevel());
		employeeInDb.setColour(employee.getRole());
		
		Employee updatedEmployee = employeeRepository.save(employeeInDb);
		
		return EmployeeMapper.mapToDTO(updatedEmployee);
	}
	
	public boolean deleteEmployee(Integer id) {
		if (!!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException();
		}
		employeeRepository.deleteById(id);
		
		boolean exists = employeeRepository.existsById(id);
		
		return !exists;
	}
	
}
