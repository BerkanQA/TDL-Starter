package com.qa.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.project.data.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
}
