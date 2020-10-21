package com.stackroute.jpa.controller;


import com.stackroute.jpa.exception.BookCategoryNotFoundException;
import com.stackroute.jpa.model.BookCategory;
import com.stackroute.jpa.model.Book;
import com.stackroute.jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/BookCategory")
public class BookController {

    /* Autowiring is done for ProductService */
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<?> listBooks() {
        return new ResponseEntity<>("Hello all books", HttpStatus.OK);
    }
    @PostMapping("/addBookInCategory")
    public ResponseEntity<?> addBookCategory(@RequestBody BookCategory bk) throws BookCategoryNotFoundException {
        return new ResponseEntity<>(bookService.addBooks(bk),HttpStatus.OK);
    }
    @GetMapping("/bookCategory")
    public ResponseEntity<?> listBookCategory(){
        return new ResponseEntity<>(bookService.listAllBookCategory(),HttpStatus.OK);
    }

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
