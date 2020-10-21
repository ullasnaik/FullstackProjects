package com.stackroute.jpa.service;

import com.stackroute.jpa.exception.BookCategoryNotFoundException;
//import com.stackroute.example.model.Product;
//import com.stackroute.example.repository.ProductRepository;
import com.stackroute.jpa.model.Book;
import com.stackroute.jpa.model.BookCategory;
import com.stackroute.jpa.repository.BookCategoryRepository;
import com.stackroute.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    private BookCategoryRepository bookCategoryRepository;
    private BookRepository bookRepo;
    @Autowired
    public BookServiceImpl(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Override
    public BookCategory addBooks(BookCategory bk) {

       Set<Book> books = bk.getBooks();
        for (Book book : books) {
            book.setBookCategory(bk);
        }

        Iterator<Book> it = books.iterator();
        while(it.hasNext()){

            System.out.println("from iterablr"+it.next());
        };

        bk.setBooks(books);

        return bookCategoryRepository.save(bk);

    }
    @Override
    public List<Book> listAllBooks(){
        return bookRepo.findAll();

    }
    @Override
    public List<BookCategory> listAllBookCategory(){
        return bookCategoryRepository.findAll();
    }

}
