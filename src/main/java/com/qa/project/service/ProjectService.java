package com.qa.project.service;

import java.awt.List;
import java.util.ArrayList;

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
		List<Project> returnables = new ArrayList<ProjectDTO>();
		
		employeesInDb.forEach(project -> returnables.add(projectMapper.mapToDTO(project)));
		
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
		boolean doesItExistSTill = projectRepository.existsById(id);
		
		return !doesItExistStill;
	}
	
}
