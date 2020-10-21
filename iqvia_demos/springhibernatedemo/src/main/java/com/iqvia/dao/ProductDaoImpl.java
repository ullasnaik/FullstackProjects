package com.iqvia.dao;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iqvia.model.Product;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Product addProduct(Product product) {
	
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(product);
		return null;
	}

}
