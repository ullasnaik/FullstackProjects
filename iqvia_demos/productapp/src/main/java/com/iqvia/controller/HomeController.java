package com.iqvia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homepage(ModelMap model) {
		model.addAttribute("message", "Model Data from Controller");
		return "index";
	}

	@GetMapping("/home/{code}")
	public ModelAndView queryParamtest(@RequestParam("category") String category, 
			@RequestParam("highprice") int price,
			@PathVariable("code") int code) {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("category", "Category received : " + category);
		modelAndView.addObject("price", "Price received : " + price);
		modelAndView.addObject("code", "code received : " + code);
		return modelAndView;
	}
}
