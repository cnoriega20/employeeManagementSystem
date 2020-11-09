package com.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootRestApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApiApplication.class, args);
	}

}
