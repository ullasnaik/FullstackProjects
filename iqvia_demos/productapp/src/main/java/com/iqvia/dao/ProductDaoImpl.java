package com.iqvia.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private static List<Product> productRepository = new ArrayList<>();

	@Override
	public Product addProduct(Product product) {
		productRepository.add(product);
		return product;
	}

	@Override
	public Product getProduct(int productCode) {
		return null;
	}

	@Override
	public List<Product> getProducts() {
		return productRepository;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(int prodCode) {

		Iterator<Product> iterator = productRepository.iterator();
		boolean found = false;
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getProdCode() == prodCode) {
				iterator.remove();
				found = true;
				break;
			}
		}
		return found;

	}

}
