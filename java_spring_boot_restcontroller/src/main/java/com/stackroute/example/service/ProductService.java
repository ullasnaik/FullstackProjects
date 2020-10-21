package com.stackroute.example.service;

import com.stackroute.example.exception.ProductNotFoundException;
import com.stackroute.example.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    Product updateProduct(Product product) throws ProductNotFoundException;

    void deleteProduct(int productId) throws ProductNotFoundException;

    List<Product> listAllProducts();

    Product getProductById(int productId) throws ProductNotFoundException;
}
