package com.qa.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandlers {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeNotFoundExceptionHandler(EmployeeNotFoundException dnfe) {
		
		return new ResponseEntity<String>(dnfe.getMessage(), HttpStatus.NOT_FOUND);
	}
}
