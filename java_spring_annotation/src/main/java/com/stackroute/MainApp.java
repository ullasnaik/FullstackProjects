package com.stackroute;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Company company = ctx.getBean(Company.class);
        company.showEmployeeInfo();
        ctx.close();
    }
}
