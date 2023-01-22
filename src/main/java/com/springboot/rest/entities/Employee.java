package com.springboot.rest.entities;

import io.swagger.annotations.ApiModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@ApiModel(description = "Employee Entity object")
@Builder
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
