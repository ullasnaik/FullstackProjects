package com.iqvia.dao;

import java.util.List;

import com.iqvia.model.Product;

public interface ProductDao {
	
	boolean addProduct(Product product);
	
	Product getProduct(int productCode);
	
	boolean removeProduct(int productCode);
	
	boolean updateProduct(int ProdCode, String name);
	
	List<Product> getProductsByCategory(String category);
	
	List<Product> getProducts();

}
