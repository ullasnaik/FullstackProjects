package com.sr.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sr.model.Customer;

public class CustRepository {
	
	List<Customer> custlist = null;

	public CustRepository() {
		custlist = new ArrayList<Customer>();
	}

	public List<Customer> getList() {
		return custlist;	}

	public void setList(List<Customer> list) {
		      custlist=list;
	}

	

	public void addCust(Customer customer) {
         custlist.add(customer); 
	}

	public boolean deleteCustomer(int custno) {
		Customer customer = new Customer();
		Iterator<Customer> itr = custlist.iterator();
		while(itr.hasNext()){
			customer=(Customer)itr.next();
			if(customer.getCustno()== custno){
				boolean b=custlist.remove(customer);
				return b;
			}
		}
		return false;
	}
		
	public List<Customer> getAllCustomers() {
				return custlist;
	}
	
	public boolean exists(int custno) {
		Customer customer = new Customer();
		boolean flag=false;
		Iterator<Customer> itr = custlist.iterator();
		while(itr.hasNext()){
			customer=(Customer)itr.next();
			if(customer.getCustno()== custno){
				flag=true;
			}
		}
		return flag;
	}
}