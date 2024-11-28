package com.example.Employee_Management_System_with_Spring_Boot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementSystemWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemWithSpringBootApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
