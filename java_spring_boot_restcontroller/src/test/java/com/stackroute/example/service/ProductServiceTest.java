package com.stackroute.example.service;

import com.stackroute.example.model.Product;
import com.stackroute.example.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private List<Product> productList;

    private Product product;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        productList = new ArrayList<>();
        product = new Product(1,"Phone","Smartphone", 20000);
        productList.add(product);

    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void whenCalledShouldReturnAllProducts() {
        when(productRepository.findAll()).thenReturn(productList);
        assertEquals(productList,productService.listAllProducts());

        verify(productRepository, times(1)).findAll();

    }

    @Test
    public void whenAddingShouldReturnAddedProduct() {
        when(productRepository.save(any())).thenReturn(product);
        assertEquals(product,productService.addProduct(product));

        verify(productRepository, times(1)).save(any());

    }

}
