package com.qa.project.mappers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.project.dto.ProjectDTO;
import com.qa.project.model.Project;

@Component
public class ProjectMapper {

	private ModelMapper modelMapper;
	
	@Autowired
	public ProjectMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public ProjectDTO mapToDTO(Project project) {
		return this.modelMapper.map(project, ProjectDTO.class);
	}
	
	public Project mapToProject(ProjectDTO projectDTO) {
	
	return this.modelMapper.map(projectDTO, Project.class);
	
}
}
