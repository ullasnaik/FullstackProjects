package com.stackroute.keepnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration 
 * and @ComponentScan with their default attributes
 * 
 * Add @EnableAspectJAutoProxy and @EnableDiscoveryClient
 * 
 */

@SpringBootApplication
public class CategoryServiceApplication {
	/*
	 * Define the bean for Filter registration. Create a new FilterRegistrationBean
	 * object and use setFilter() method to set new instance of JwtFilter object.
	 * Also specifies the Url patterns for registration bean.
	 */
	@Bean
	public FilterRegistrationBean jwtFilter() {
		return null;
	}

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
		SpringApplication.run(CategoryServiceApplication.class, args);
	}
}








	
	

	
	
	

