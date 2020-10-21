package com.sr.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sr.model.Customer;

@Configuration
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	@Bean
	@Autowired
	public DataSource getDataSource() {
	 BasicDataSource datasource = new BasicDataSource();
	 datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 datasource.setUrl("jdbc:mysql://localhost:3306/test"+
	      "?verifyServerCertificate=false&useSSL=false&requireSSL=false");
	 datasource.setUsername("root");
	 datasource.setPassword("root");
	 return datasource;
	}
	
	//Define the bean for SessionFactory
	@Bean
	@Autowired
	public LocalSessionFactoryBean getLocalSessionFactory(DataSource datasource) throws 
	IOException{
		
	LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	sessionFactoryBean.setDataSource(datasource);
	Properties properties = new Properties();
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL5Dialect");
	properties.put("hibernate.hbm2ddl.auto", "update");
	sessionFactoryBean.setAnnotatedClasses(Customer.class);
	sessionFactoryBean.setHibernateProperties(properties);
	sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean;
	}
		
	//Define the Bean for Transaction Manager
		
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
	  HibernateTransactionManager transaction = new HibernateTransactionManager();
	  transaction.setSessionFactory(sessionFactory);
		return transaction;
	}
		
		
		
			
		
	}
	
	


