package com.iqvia.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iqvia.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	private SessionFactory sessionFactory;

	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addProduct(Product product) {

		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			currentSession.save(product);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Product getProduct(int productCode) {
		return this.sessionFactory.getCurrentSession().get(Product.class, productCode);
	}

	@Override
	public boolean removeProduct(int productCode) {
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			Product product = currentSession.get(Product.class, productCode);
			currentSession.delete(product);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateProduct(int productCode, String name) {

		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			Product product = currentSession.get(Product.class, productCode);
			product.setName(name);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Product p where p.category = :catg");
		query.setParameter("catg", category);
		List<Product> products = query.list();
		return products;
	}

	@Override
	public List<Product> getProducts() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Product");
		List<Product> products = query.list();
		return products;
	}

}
