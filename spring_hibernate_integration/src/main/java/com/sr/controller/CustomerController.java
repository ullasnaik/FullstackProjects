package com.sr.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sr.model.Customer;
import com.sr.repository.CustomerDao;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private Customer customer;

	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerController(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
    @GetMapping(value="/")
    public String indexPage(ModelMap model) {
    	model.addAttribute("custList", customerDao.getAllCustomers());
		return "index";
    }
    
    @PostMapping(value="/add")
    public String addCustomer(@ModelAttribute("customer") Customer customer, ModelMap 
    		model) {
    	     if(customer.getCustname().isEmpty()) {
    	    	 model.addAttribute("errorMessage", "Fields should not be empty");
    	    	 return "index";
    	     } else {
    	    	 customer.setCreatedAt(LocalDateTime.now());
    	    	 customerDao.saveCustomer(customer);
    	    	 return "redirect:/";
    	     }
    }
     @RequestMapping("/delete")
     public String deleteCustomer(@RequestParam int custno, ModelMap model) {
    	 customerDao.deleteCustomer(custno);
		return "redirect:/";
     }
     
     @RequestMapping(value="/updateCustomer")
     public String updateCustomer(@RequestParam int custno, ModelMap model) {
		 model.addAttribute("customer", customerDao.getCustomerByCustno(custno));
    	 return "update";
     }
     
     @RequestMapping(value="/update")
     public String update(@ModelAttribute("customer") Customer customer, ModelMap model)
     {
    	 customer.setCreatedAt(LocalDateTime.now());
    	 customerDao.updateCustomer(customer);
    	 return "redirect:/";
     }
}
