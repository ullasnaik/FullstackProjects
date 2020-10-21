package com.sr.repository;

import java.util.List;

import com.sr.model.Customer;

public interface CustomerDao {
	
	public boolean saveCustomer(Customer customer);
	public boolean deleteCustomer(int custno);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByCustno(int custno);
	public boolean updateCustomer(Customer customer);

}
