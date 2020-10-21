package com.shopping.catalogservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CatalogController {

    @Autowired
    private Environment environment;

    @GetMapping("/api/products/hello")
    public String sayHello(){
        return "Hello From Catalog Service running at port "  + environment.getProperty("server.port");
    }
}
