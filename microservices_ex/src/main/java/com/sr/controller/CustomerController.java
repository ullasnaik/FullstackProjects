package com.sr.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sr.model.Customer;
import com.sr.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Customer> getAllCustomers() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Customer getCustomerById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyCustomerById(@PathVariable("id") ObjectId id, 
			  @Valid @RequestBody Customer customer) {
	    customer.set_id(id);
	    repository.save(customer);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Customer createCustomer(@Valid @RequestBody Customer customer) {
	    customer.set_id(ObjectId.get());
	    repository.save(customer);
	    return customer;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deletePet(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }	
}
