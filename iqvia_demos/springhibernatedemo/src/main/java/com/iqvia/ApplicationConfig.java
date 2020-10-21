package com.iqvia;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.iqvia")
@PropertySource("classpath:dbConfig.properties")
public class ApplicationConfig {
	
	@Autowired
	private Environment env;
	
	//Datasource bean
	@Bean
	public DataSource datasource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		dataSource.setDriverClassName(env.getProperty("db.driver.classname"));
		return dataSource;
	}
	
	//Session factory bean and inject datasource bean
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource datasource) throws IOException {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(datasource);
		//Set the packages to scan for Object - Relation mapping
		sessionFactoryBean.setPackagesToScan("com.iqvia.model");
		//Set the hibernate properties
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create"); //create, update, validate, none
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		sessionFactoryBean.setHibernateProperties(properties);
		sessionFactoryBean.afterPropertiesSet();
		
		return sessionFactoryBean;
	}
	
	//Transaction Manager and inject session factory
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);
		return manager;
	}
}