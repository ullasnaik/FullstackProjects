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

import com.dao.model.Product;
import com.iqvia.dao.ProductDao;

@Controller
public class ProductController {

	private ProductDao productDao;

	@Autowired
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}

	@GetMapping("/productform")
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
	
//	@PostMapping("/addProduct")
//	public String addProduct(@ModelAttribute Product product, Model model) {
//		productDao.addProduct(product);
//		return "redirect:/productform";
//	}

//	@PostMapping("/addProduct")
//	public ModelAndView addProduct(@RequestParam("prodCode") int prodCode,
//			@RequestParam("name") String name,
//			@RequestParam("price") double price,
//			@RequestParam("category") String category) {
//		Product product = new Product(prodCode, name, category, price);
//		productDao.addProduct(product);
//		ModelAndView modelAndView = new ModelAndView("redirect:/productform");
//		return modelAndView;
//	}

	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("prodCode") int prodCode) {
		productDao.deleteProduct(prodCode);
		return "redirect:/productform";
	}

}
