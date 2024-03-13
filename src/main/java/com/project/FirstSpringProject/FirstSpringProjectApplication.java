package com.project.FirstSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "java.com.project.controller")
@SpringBootApplication
public class FirstSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringProjectApplication.class, args);

	}
}
