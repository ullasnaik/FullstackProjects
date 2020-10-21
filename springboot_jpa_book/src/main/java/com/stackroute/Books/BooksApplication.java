package com.stackroute.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication implements CommandLineRunner {

	@Autowired
	private BookRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Override
	public void run(String ... arg){
		repository.save(new Book("c++","aa"));
		repository.save(new Book("JDBC","aa"));
		System.out.println("the record is inserted");
		System.out.println("\nFind All");
		repository.findAll().forEach(x -> System.out.println(x));


		System.out.println("-----Find the book bt ID---------");
		repository.findById(2L).ifPresent(x-> System.out.println(x));

		System.out.println("-------Find by name------------");
		repository.findByName("c++").forEach(x-> System.out.println(x));


		System.out.println("-----------Find by Author----------");
		repository.findByAuthor("aa").forEach(x-> System.out.println(x));


		System.out.println("------------Delete-------");
		repository.deleteByName("c++");

	}
}
