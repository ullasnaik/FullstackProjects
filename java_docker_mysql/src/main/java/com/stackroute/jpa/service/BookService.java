package com.stackroute.jpa.service;

import com.stackroute.jpa.model.BookCategory;
import  com.stackroute.jpa.model.Book;


import java.util.List;

public interface BookService {
    BookCategory addBooks(BookCategory bk);
    List<Book> listAllBooks();
    List<BookCategory> listAllBookCategory();
}
