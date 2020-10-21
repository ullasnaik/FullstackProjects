package com.iqvia.springaopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService productService = context.getBean(ProductService.class);
		productService.addProduct();
		productService.placeOrder();
		
	}

}
