package com.sr.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sr.model.Customer;
import com.sr.repository.CustRepository;

@Controller
public class CustController {
	
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	Customer custObj=(Customer)ctx.getBean("customer");
	CustRepository custRepObj=(CustRepository)ctx.getBean("custRepository");

	
	@GetMapping(value= "/")
	public String getCustomers(ModelMap map)
	{
		List list=(List) custRepObj.getAllCustomers();
 		map.put("custList",list);
		return "index";
	}
	
	@RequestMapping(value="/saveCustomer",method=RequestMethod.POST)
	public String addNewCustomer(@Validated @ModelAttribute("Customer")Customer customer,ModelMap map)
	{

		LocalDateTime dt=LocalDateTime.now();
		customer.setCreatedAt(dt);
		custRepObj.addCust(customer);
		List list=(List) custRepObj.getAllCustomers();
		map.put("custList",list);
		return "index";	
	}
	
	
		@RequestMapping(value="/deleteCustomer",method=RequestMethod.GET)
		public String deleteCustomer(@RequestParam("custno") int custno)
		{
			boolean del=custRepObj.deleteCustomer(custno);
			return "redirect:/";
		}

}
