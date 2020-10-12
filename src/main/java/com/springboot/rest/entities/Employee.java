package com.springboot.rest.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class Employee {

	private @Id @GeneratedValue Long id;

	@Size(min = 2, max = 200)
	private String name;

	private String role;
	
	public Employee() {}
	
	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}
}
