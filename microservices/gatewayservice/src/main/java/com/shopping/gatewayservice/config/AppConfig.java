package com.shopping.gatewayservice.config;

import com.shopping.gatewayservice.filter.JWTValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    public static final String CATALOG_API_URL = "/catalog/api/products/*";
    public static final String INVENTORY_API_URL = "/inventory/api/products/*";

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JWTValidationFilter());
        filterRegistrationBean.addUrlPatterns(CATALOG_API_URL,
                INVENTORY_API_URL);
        return filterRegistrationBean;
    }
}
