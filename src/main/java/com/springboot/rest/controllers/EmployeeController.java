/**
 * 
 */
package com.springboot.rest.controllers;

import com.springboot.rest.entities.Employee;
import com.springboot.rest.exceptions.EmployeeNotFoundException;
import com.springboot.rest.repositories.EmployeeRepository;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cnoriega
 *
 */
@RestController
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	  EmployeeController(EmployeeRepository employeeRepository) {
	    this.employeeRepository = employeeRepository;
	  }

	  // Aggregate root

	  @GetMapping("/employees")
	  List<Employee> getAll() {
	    return employeeRepository.findAll();
	  }

	  @PostMapping("/employees")
	  public Employee getNewEmployee(@RequestBody  @Valid Employee newEmployee) {
	    return employeeRepository.save(newEmployee);
	  }

	  // Single item

	  @GetMapping("/employees/{id}")
	  public Employee getOne(@PathVariable Long id) {

	    return employeeRepository.findById(id)
	      .orElseThrow(() -> new EmployeeNotFoundException(id));
	  }

	  @PutMapping("/employees/{id}")
	  public Employee updateEmployee(@RequestBody @Valid Employee newEmployee, @PathVariable Long id) {

	    return employeeRepository.findById(id)
	      .map(employee -> {
	        employee.setFirstName(newEmployee.getFirstName());
			employee.setLastName(newEmployee.getLastName());
			employee.setEmail(newEmployee.getEmail());
	        employee.setRole(newEmployee.getRole());
	        return employeeRepository.save(employee);
	      })
	      .orElseGet(() -> {
	        newEmployee.setId(id);
	        return employeeRepository.save(newEmployee);
	      });
	  }

	  @DeleteMapping("/employees/{id}")
	  void deleteEmployee(@PathVariable Long id)  {
		  employeeRepository.deleteById(id);
	  }
}
