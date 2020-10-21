package com.stackroute.Books;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface BookRepository extends CrudRepository<Book,Long>{
    List<Book> findByName(String name);
    List<Book> findByAuthor(String author);
    void deleteByName(String name);
}
