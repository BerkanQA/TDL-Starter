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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.project.data.model.Project;
import com.qa.project.dto.ProjectDTO;
import com.qa.project.service.ProjectService;




@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

	private ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping
	public ResponseEntity<List<ProjectDTO>> getAllProject() {
		List<ProjectDTO> data = projectService.readAllProjects();

		return new ResponseEntity<List<ProjectDTO>>(data, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody Project project) {
		ProjectDTO newProject = projectService.createProject(project);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newProject.getId()));

		return new ResponseEntity<ProjectDTO>(newProject, headers, HttpStatus.CREATED);
	}
	
		@DeleteMapping("/{id}")
		public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") int id) {		
			return new ResponseEntity<Boolean>(projectService.deleteProject(id), HttpStatus.OK);
		}
	}


