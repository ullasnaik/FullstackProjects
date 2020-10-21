package com.stackroute.fitnesszone.enquiryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EnquiryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnquiryServiceApplication.class, args);
	}

}
