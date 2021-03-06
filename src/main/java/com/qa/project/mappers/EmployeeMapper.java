package com.qa.project.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.project.dto.EmployeeDTO;
import com.qa.project.model.Employee;

@Component
public class EmployeeMapper {
	
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployeeMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public EmployeeDTO mapToDTO(Employee employee) {
		return this.modelMapper.map(employee, EmployeeDTO.class);
	}

	public Employee mapToEmployee(Employee employeeDTO) {
		return this.modelMapper.map(employeeDTO, Employee.class);
	}



}
