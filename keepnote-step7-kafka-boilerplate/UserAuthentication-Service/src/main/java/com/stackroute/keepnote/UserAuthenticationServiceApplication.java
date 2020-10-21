package com.stackroute.keepnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration 
 * and @ComponentScan with their default attributes
 * 
 * Add @EnableDiscoveryClient
 * 
 */

@SpringBootApplication
public class UserAuthenticationServiceApplication {


	/*
	 * Define the bean for WebMvcConfigurer. Create a new WebMvcConfigurerAdapter object 
     * and add addCorsMappings(CorsRegistry registry) method to set addMapping and allowedOrigins
	 */
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return null;
    }

	/*
	 * 
	 * You need to run SpringApplication.run, because this method start whole spring
	 * framework. Code below integrates your main() with SpringBoot
	 */

	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationServiceApplication.class, args);
	}
}


