package com.stackroute;

public class HelloWorld {
    private String message;
    HelloWorld(String myMessage){
        this.message = myMessage;
    }
//    public void setMessage(String message){
//        this.message = message;
//    }
    public void getMessage(){
        System.out.println("Your message is :"+message);
    }
}
