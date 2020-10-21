package com.stackroute;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeptMain {

	public static void main(String[] args) {
		
		    Configuration cfg=new Configuration();  
		    cfg.configure("hibernate.cfg.xml");  //populates the data of the configuration file  
		      
		    //creating session factory object
		   	SessionFactory factory=cfg.buildSessionFactory();  
		      
		    //creating session object  
		    Session session=factory.openSession();  
		      
		    //creating transaction object  
		    Transaction tx=session.beginTransaction();  
		    
		    
		    //Retriving Data from table
		       String SQL_QUERY="from Dept dept";
		       Query query = session.createQuery(SQL_QUERY);
		       
//		       for(Iterator it =query.iterate();it.hasNext();) {
//		    	   Dept dept = (Dept) it.next();
//		    	   System.out.print("Deptno : " + dept.getDeptno() );
//		    	   System.out.print("DName : " + dept.getDname() );
//		    	   System.out.print("Location : " + dept.getLoc());
//		    	   System.out.println();
//		    	   
//		       }
//		       tx.commit(); 
		   
		       //To delete a record
//		       Query query1 = session.createQuery("delete from Dept where deptno =40");
//		       query1.executeUpdate();
//		       tx.commit(); 
//	           System.out.println("Record deleted Succesfully..!!!");
		       
		       //Use of select in HQL 
//				String SQL_QUERY1 ="select d.dname from Dept d"; 
//				Query query1 = session.createQuery(SQL_QUERY1);
//				for(Iterator it=query1.iterate();it.hasNext();)
//				  { 
//					String x =(String) it.next(); 
//					System.out.println("Name: " + x); 
//					} 
//				tx.commit();
	}

}
