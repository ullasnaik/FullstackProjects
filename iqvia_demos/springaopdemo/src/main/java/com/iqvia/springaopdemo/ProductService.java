package com.iqvia.springaopdemo;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	
	public void addProduct() {
		System.out.println("Business functionality for adding product to DB");
	}
	
	public void placeOrder() {
		System.out.println("Business functionality for placing order");
	}

}
