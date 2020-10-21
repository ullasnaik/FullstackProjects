package com.sr.dao;

import java.util.List;

import com.sr.model.Employee;

public interface EmployeeDao {
	 
	 public List<Employee> getEmployees();
	 
	 public Employee getEmployee(Long id);
	 
	 public void deleteEmployee(Long id); 
	 
	 public void updateEmployee(Long id, Employee employee);
	 
	 public long createEmployee(Employee employee);
	
}

