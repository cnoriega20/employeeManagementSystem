package com.springboot.rest.entities;

import io.swagger.annotations.ApiModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Table(name = "Employee")
@ApiModel(description = "Employee Entity object")

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

	private @Id @GeneratedValue Long id;

	@Size(min = 2, max = 200, message="Name should be at least two characters")
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "role")
	private String role;


	public Employee(String cesar, String noriega, String s, String sw) {
	}
}
