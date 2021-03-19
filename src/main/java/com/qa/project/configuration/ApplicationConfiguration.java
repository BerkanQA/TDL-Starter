package com.qa.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// Configuration is used here to supply beans to configure the application
@Configuration
public class ApplicationConfiguration {

	// Creates a new bean for this ModelMapper bean
	@Bean
	@Scope("prototype")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
