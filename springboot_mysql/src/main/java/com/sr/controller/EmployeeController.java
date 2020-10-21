package com.sr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sr.exception.EmployeeNotFoundException;
import com.sr.model.Employee;
import com.sr.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
    EmployeeRepository empRepository;

	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
	    return empRepository.findAll();
	}
	
	// Create a new Employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
	    return (Employee) empRepository.save(employee);
	}
	
	// Get a Single Employee
	@GetMapping("/employees/{empno}")
	public Employee getEmployeeById(@PathVariable(value = "empno") Long empno) throws Throwable {
	    return (Employee) empRepository.findById(empno)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee", "empno", empno));
	}
	
	// Update a Employee
	@PutMapping("/employees/{empno}")
	public Employee updateEmployee(@PathVariable(value = "empno") Long empno,
	                                        @Valid @RequestBody Employee empDetails) throws Throwable {

	    Employee employee = (Employee) empRepository.findById(empno)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee", "empno", empno));

	    employee.setEname(empDetails.getEname());
	    employee.setDesig(empDetails.getDesig());
	    Employee updatedEmployee = (Employee) empRepository.save(employee);
	    return updatedEmployee;
	}
	
	// Delete a Employee
	@DeleteMapping("/employees/{empno}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "empno") Long empno) throws Throwable {
	    Employee employee = (Employee) empRepository.findById(empno)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee", "empno", empno));

	    empRepository.delete(employee);

	    return ResponseEntity.ok().build();
	}
	
	
	}
