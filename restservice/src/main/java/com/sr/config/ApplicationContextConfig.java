 package com.sr.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "com.sr")
public class ApplicationContextConfig {

	@Bean
	@Autowired
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test"
				+"?verifyServerCertificate=false&useSSL=false&requireSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
 		return dataSource;
	}

		@Bean
	       @Autowired
           public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) throws IOException {

    		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    		sessionFactoryBean.setDataSource(dataSource);
    		sessionFactoryBean.setPackagesToScan(new String[] { "com.sr" });
    		Properties properties = new Properties();
    		properties.put("hibernate.show_sql", "true");
    		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    		properties.put("hibernate.hbm2ddl.auto", "update");
     		sessionFactoryBean.setHibernateProperties(properties);
     		sessionFactoryBean.afterPropertiesSet();
    		return sessionFactoryBean;

	       }
	
	    @Bean
	   	@Autowired
	   	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

	   		HibernateTransactionManager transaction = new HibernateTransactionManager();
	   		transaction.setSessionFactory(sessionFactory);
	   		return transaction;
	   	}

	       
    		
}
