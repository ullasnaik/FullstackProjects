package com.sr.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sr.model.Employee;

@Component
public class EmployeeDao {
	
	public Employee getEmployeeById(Integer employeeId) {
		System.out.println("Calling the Method getEmployeeByID");
		return new Employee();
	}
	
	public  List<Employee> getAllEmployee(){
		System.out.println("Calling the Method getAllEmployee");
		return new ArrayList<Employee>();
	}

	public void createEmployee(Employee employee) {
		System.out.println("Create Employee Method is called");
	}
	
	public void deleteEmployee(Integer employeeId) {
		System.out.println("Delete Employee Method is called");
	}
	
	
	public void updateEmployee(Integer employeeId) {
		System.out.println("Calling the Method updateEmployee");
	}
	
	
	
	
	
	
	

}
