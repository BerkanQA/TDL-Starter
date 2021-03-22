package com.qa.project.hateoas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.qa.project.controller.EmployeeController;
import com.qa.project.dto.EmployeeDTO;
import com.qa.project.mappers.EmployeeMapper;
import com.qa.project.model.Status;

@Component
public class EmployeeDTOModelAssembler implements RepresentationModelAssembler<EmployeeDTO, EntityModel<EmployeeDTO>> {

	private EmployeeMapper employeeMapper;

	@Autowired
	public EmployeeDTOModelAssembler(EmployeeMapper employeeMapper) {
		super();
		this.employeeMapper = employeeMapper;
	}

	@Override
	public EntityModel<EmployeeDTO> toModel(EmployeeDTO entity) {
		EntityModel<EmployeeDTO> entityModel = EntityModel.of(entity,
				linkTo(methodOn(EmployeeController.class).getEmployeeById(entity.getId()).withSelfRel()
						.withTitle("GET")),
				linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("employees").withTitle("GET"));
		if (entity.getStatus().equals(Status.PERCHED)) {
			entityModel.add(
					linkTo(methodOn(EmployeeController.class).deleteEmployee(entity.getId())).withRel("delete").withTitle("DELETE"),
					linkTo(methodOn(EmployeeController.class).updateEmployee(entity.getId(), employeeMapper.mapToEmployee(entity))).withRel("update").withTitle("PUT")
			);
	}
	
}
