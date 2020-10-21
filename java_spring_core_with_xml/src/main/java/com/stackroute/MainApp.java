package com.stackroute;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String ... arg){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld helloObj = (HelloWorld)context.getBean("helloWorld");
        helloObj.getMessage();
//        HelloWorld hiObj = (HelloWorld)context.getBean("sayHi");
//        hiObj.getMessage();
//        HelloWorld byeObj = (HelloWorld)context.getBean("seeYouSoon");
//        byeObj.getMessage();
//        HelloWorld checkObj = (HelloWorld)context.getBean("check");
//        checkObj.getMessage();

    }
}
