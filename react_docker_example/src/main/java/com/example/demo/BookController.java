package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/BookCategory")
public class BookController {
    @CrossOrigin
    @GetMapping("/books")
    public ResponseEntity<Object> listBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "key-1", "value-1",
                "key-2", "value-2",
                "key-3", "value-3"));
    }
//    @PostMapping("/addBookInCategory")
//    public ResponseEntity<?> addBookCategory(@RequestBody BookCategory bk) throws BookCategoryNotFoundException {
//        return new ResponseEntity<>(bookService.addBooks(bk),HttpStatus.OK);
//    }
//    @GetMapping("/bookCategory")
//    public ResponseEntity<?> listBookCategory(){
//        return new ResponseEntity<>(bookService.listAllBookCategory(),HttpStatus.OK);
//    }

//    @GetMapping("/{productId}")
//    public ResponseEntity<?> getProductById(@PathVariable int productId) throws ProductNotFoundException {
//        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<?> addProduct(@RequestBody Product product) {
//        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
//    }
//
//    @PutMapping
//    public ResponseEntity<?> updateProduct(@RequestBody Product product) throws ProductNotFoundException {
//        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{productId}")
//    public ResponseEntity<?> deleteProduct(@PathVariable int productId) throws ProductNotFoundException {
//        productService.deleteProduct(productId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
}
