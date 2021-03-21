package com.qa.project.service;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.project.data.model.Project;
import com.qa.project.data.repository.ProjectRepository;
import com.qa.project.dto.ProjectDTO;
import com.qa.project.mappers.ProjectMapper;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;
	
	private ProjectMapper projectMapper;
	
	@Autowired
	public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
		this.projectRepository = projectRepository;
		this.projectMapper = projectMapper;
	}
	
	public List<ProjectDTO> readAllProjects() {
		List<Project> projectsInDb = projectRepository.findAll();
		List<ProjectDTO> returnables = new ArrayList<ProjectDTO>();
		
		projectsInDb.forEach(project -> returnables.add(projectMapper.mapToDTO(project)));
		
		return returnables; 
	}
	
	public ProjectDTO createProject(Project project) {
		Project savedProject = projectRepository.save(project);
		
		return projectMapper.mapToDTO(savedProject);
	}
	public Boolean deleteProject(Integer id) {
		if (projectRepository.existsById(id)) {
			projectRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}
		boolean doesItExistStill = projectRepository.existsById(id);
		
		return !doesItExistStill;
	}
	
}
