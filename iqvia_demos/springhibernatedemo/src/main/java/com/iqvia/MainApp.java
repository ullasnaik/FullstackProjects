package com.iqvia;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iqvia.dao.ProductDao;
import com.iqvia.model.Product;

public class MainApp {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		ProductDao productDao = context.getBean(ProductDao.class);
		productDao.addProduct(new Product(101, "laptop", "electronics", 10000));
		
	}

}
