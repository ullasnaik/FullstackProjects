package com.iqvia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.dao.ProductDao;
import com.iqvia.model.Product;

@RestController
public class ProductController {

	private ProductDao productDao;

	@Autowired
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@GetMapping("/products/{productCode}")
	public ResponseEntity<?> getProduct(@PathVariable("productCode") int productCode ) {
		
		ResponseEntity<?> response = null;
		Product product = productDao.getProduct(productCode);
		
		if(product != null) {
			response = new ResponseEntity<Product>(product, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("Product not found", HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts( ) {
		List<Product> products = productDao.getProducts();
		return products;
	}
	
	@PostMapping("/products")
	@ResponseStatus(value = HttpStatus.CREATED)  //  201
	public void addProduct(@RequestBody Product product) {
		productDao.addProduct(product);
	}
	
	@DeleteMapping("/products/{productCode}")
	public void deleteProduct(@PathVariable("productCode") int productCode) {
		productDao.removeProduct(productCode);
	}
	
}