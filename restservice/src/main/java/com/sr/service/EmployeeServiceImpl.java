package com.sr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.dao.EmployeeDao;
import com.sr.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	 @Autowired
	 private EmployeeDao employeeDao;
	 
	 public List<Employee> getEmployees() {
	  List<Employee> employees = employeeDao.getEmployees();
	  return employees;
	 }
	 
	 public Employee getEmployee(Long id) {
	  Employee employee = employeeDao.getEmployee(id);
	  return employee;
	 }
	 
	 public void  deleteEmployee(Long id) {
	     employeeDao.deleteEmployee(id);
	 }
	 
	 public void updateEmployee(Long id, Employee employee) {
	      employeeDao.updateEmployee(id, employee);
	 }
	 
	 public Long createEmployee(Employee employee) {
	  return employeeDao.createEmployee(employee);
	 }
}
