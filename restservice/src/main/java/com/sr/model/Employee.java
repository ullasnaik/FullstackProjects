package com.sr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "emp")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 private String ename;
	 private Long age;
	 
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String ename, Long age) {
		super();
		this.id = id;
		this.ename = ename;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", age=" + age + "]";
	}

	
	
	 

}
