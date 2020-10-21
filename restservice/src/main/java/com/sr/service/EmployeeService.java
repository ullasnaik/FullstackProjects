package com.sr.service;

import java.util.List;

import com.sr.model.Employee;

public interface EmployeeService {
	 public List<Employee> getEmployees();
	 public Employee getEmployee(Long employeeId);
	 public void deleteEmployee(Long id); 
	 public void updateEmployee(Long id, Employee employee);
	 public Long createEmployee(Employee employee); 
}
