package com.stackroute;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class EmployeeMain 
{
    public static void main( String[] args )
    {
    	//creating configuration object  
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
        System.out.println("Enter Employee Code ");
        int eno = scn.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = scn.next();
              
        Employee e1=new Employee();  
        e1.setEmpno(eno);
        e1.setName(name);
          
        session.persist(e1);//persisting the object  
          
        t.commit();//transaction is commited  
        session.close();  
          
        System.out.println("successfully saved");  
          
    }
}
