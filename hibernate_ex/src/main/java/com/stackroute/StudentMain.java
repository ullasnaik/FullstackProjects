package com.stackroute;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentMain {

	public static void main(String[] args) {
	

    Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");  //populates the data of the configuration file  
      
    //creating session factory object
   	SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object  
    Transaction t=session.beginTransaction();  
    
    //Dynamic input from the user
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter Student Id ");
    int id = scn.nextInt();
    System.out.println("Enter Student Name: ");
    String name = scn.next();
          
   Student student = new Student();
   student.setId(id);
   student.setName(name);
   
      
    session.persist(student);//persisting the object  
      
    t.commit();//transaction is commited  
    session.close();  
      
    System.out.println("successfully saved");  
      
}
}