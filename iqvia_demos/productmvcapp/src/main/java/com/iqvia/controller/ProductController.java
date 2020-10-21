package com.iqvia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.iqvia.dao.ProductDao;
import com.iqvia.model.Product;

@Controller
public class ProductController {

	private ProductDao productDao;

	@Autowired
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}

	@GetMapping({"/","/productform"})
	public String showProductForm(Model model) {
		List<Product> products = productDao.getProducts();
		model.addAttribute("products", products);
		return "product_form";
	}

	@PostMapping("/addProduct")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		productDao.addProduct(product);
		ModelAndView modelAndView = new ModelAndView("redirect:/productform");
		return modelAndView;
	}
	

	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("prodCode") int prodCode) {
		productDao.removeProduct(prodCode);
		return "redirect:/productform";
	}

}
