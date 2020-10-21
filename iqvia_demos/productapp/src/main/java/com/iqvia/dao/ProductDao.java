package com.iqvia.dao;

import java.util.List;

import com.dao.model.Product;

public interface ProductDao {
	
	Product addProduct(Product product);
	Product getProduct(int productCode);
	List<Product> getProducts();
	List<Product> getProductsByCategory(String category);
	boolean deleteProduct(int prodCode);

}
