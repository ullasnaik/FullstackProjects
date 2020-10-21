package com.shopping.inventoryservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InventoryController {

    @GetMapping("api/products/hello")
    public String sayHello(){
        return "hello from Inventory Service";
    }
}
