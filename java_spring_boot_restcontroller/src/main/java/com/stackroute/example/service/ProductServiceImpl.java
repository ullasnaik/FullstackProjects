package com.stackroute.example.service;

import com.stackroute.example.exception.ProductNotFoundException;
import com.stackroute.example.model.Product;
import com.stackroute.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws ProductNotFoundException {
        if(productRepository.findById(product.getProductId()).isEmpty()) {
            throw new ProductNotFoundException();
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) throws ProductNotFoundException {
        if(productRepository.findById(productId).isEmpty()) {
            throw new ProductNotFoundException();
        }

        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) throws ProductNotFoundException {
        if(productRepository.findById(productId).isEmpty()) {
            throw new ProductNotFoundException();
        }

        return productRepository.findById(productId).get();
    }
}
