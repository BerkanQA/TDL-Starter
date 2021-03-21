package com.qa.project.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid Employee"	)
public class ProjectNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = -6705326510114331656L;

	public ProjectNotFoundException() {
		super(); // calls EntityNotFoundException()
	}

	public ProjectNotFoundException(String message) {
		super(message); // calls EntityNotFoundException(String message)
	}
}
