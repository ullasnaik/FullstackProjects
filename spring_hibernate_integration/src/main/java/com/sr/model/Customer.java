package com.sr.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Customer")
public class Customer {
	
	@Id
	@Column(name="custno")
	private int custno;
	
	@Column(name="custname")
	private String custname;
	
	@Column(name="creationdate")
	private LocalDateTime createdAt;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int custno, String custname, LocalDateTime createdAt) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.createdAt = createdAt;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Customer [custno=" + custno + ", custname=" + custname + ", createdAt=" + createdAt + "]";
	}
	
	
	
	

}
