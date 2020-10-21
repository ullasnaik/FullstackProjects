package com.sr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sr.dao.EmployeeDao;
import com.sr.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beaninfo.xml");
        EmployeeDao ed = (EmployeeDao) context.getBean(EmployeeDao.class);
        //ed.getEmployeeById(12);
        ed.createEmployee(new Employee());
     //   ed.deleteEmployee(45);
        		
        		
        		
    }
}
