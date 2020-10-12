package com.springboot.rest.entities;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
@ApiModel(description = "Employee Entity object")
public class Employee {

	private @Id @GeneratedValue Long id;

	@Size(min = 2, max = 200, message="Name should be at least two characters")
	private String name;

	private String role;
	
	public Employee() {}
	
	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}
}
