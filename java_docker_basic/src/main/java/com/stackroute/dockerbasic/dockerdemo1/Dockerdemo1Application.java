package com.stackroute.dockerbasic.dockerdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Dockerdemo1Application {

	public static void main(String[] args) {
		System.out.println("Hello Docker");
		SpringApplication.run(Dockerdemo1Application.class, args);
	}

}
