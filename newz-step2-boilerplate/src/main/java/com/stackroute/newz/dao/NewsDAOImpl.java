package com.stackroute.newz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stackroute.newz.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;


/*
 * This class is implementing the NewsDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository

public class NewsDAOImpl implements NewsDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public NewsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Save the news in the database(news) table.
	 */
	@Transactional
	public boolean addNews(News news) {
		sessionFactory.getCurrentSession().save(news);
		return true;
	}

	/*
	 * retrieve all existing news sorted by created Date in descending
	 * order(showing latest news first)
	 */
	@Transactional
	public List<News> getAllNews() {
		return sessionFactory.getCurrentSession().createCriteria(News.class).list();
	}

	/*
	 * retrieve specific news from the database(news) table
	 */
	@Transactional
	public News getNewsById(int newsId) {
		return sessionFactory.getCurrentSession().get(News.class,newsId);
	}

	@Transactional
	public boolean updateNews(News news) {
		sessionFactory.getCurrentSession().saveOrUpdate(news);
		return true;
	}

	/*
	 * Remove the news from the database(news) table.
	 */
	@Transactional
	public boolean deleteNews(int newsId) {
		sessionFactory.getCurrentSession().saveOrUpdate(getNewsById(newsId));
		return true;
	}
}