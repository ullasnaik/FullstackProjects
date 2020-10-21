package com.sr.controller;


import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sr.model.Employee;

@RestController
@CrossOrigin(origins="*")
public class EmpController {
	
	
	@GetMapping()
	public String Welcome() {
		return "Learning is Easy";
	}
	
	 @GetMapping("/get")
	   public Employee getEmployee(){
	      Employee e = new Employee();
		  e.setId(1001);
		  e.setName("Akilesh");
		  e.setCity("Bangalore");
		  return e;
	 }
	
	
	 

}
