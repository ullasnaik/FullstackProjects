package com.stackroute;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.stackroute")
public class AppConfig {

    /*
     <bean id = "helloWorld" class = "com.stackroute.HelloWorld">
<!--        <property name="message" value="Hello to all"></property>-->
        <constructor-arg type = "java.lang.String" value="Hello to constructor"></constructor-arg>
    </bean>

        @bean
        public HelloWorld getMessage(){
        return new HelloWorld("Hello to Constructor");
        }

     */
//    @Bean
//    Employee emp = new EmployeeImp();
//
   @Bean
    public Employee getEmployee(){
        return new EmployeeImp();
    }
    @Bean
    public Department getDepartment(){
        return new DepartmentImpl();

    }
}

