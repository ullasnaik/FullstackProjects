package com.stackroute.fitnesszone.apigateway.config;//package com.stackroute.fitnesszone.productservice.config;


import com.stackroute.fitnesszone.apigateway.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {

        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
        filter.addUrlPatterns("/productservice/api/v1/programservice/*");

        return filter;
    }
}
