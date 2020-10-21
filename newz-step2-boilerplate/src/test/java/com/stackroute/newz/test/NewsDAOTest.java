package com.stackroute.newz.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.stackroute.newz.config.ApplicationContextConfig;
import com.stackroute.newz.dao.NewsDAO;
import com.stackroute.newz.dao.NewsDAOImpl;
import com.stackroute.newz.model.News;

@ExtendWith(SpringExtension.class)
@Transactional
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class NewsDAOTest {

	@Autowired
	private SessionFactory sessionFactory;
	private NewsDAO newsDAO;
	private News news;

	@BeforeEach
	public void setUp() throws Exception {
		newsDAO = new NewsDAOImpl(sessionFactory);
		news = new News(1, "Indian Express", "Political", "CAA", "amendment", LocalDateTime.now());
	}

	@AfterEach
	public void tearDown() throws Exception {
		Query query = sessionFactory.getCurrentSession().createQuery("Delete from News");
		query.executeUpdate();
	}

	@Test
	@Rollback(true)
	public void testSaveNewsSuccess() {
		newsDAO.addNews(news);
		List<News> newsList = newsDAO.getAllNews();
		assertEquals("Indian Express", newsList.get(0).getName());
		newsDAO.deleteNews(news.getNewsId());
	}

	@Test
	@Rollback(true)
	public void testSaveNewsFailure() {
		newsDAO.addNews(news);
		List<News> newsList = newsDAO.getAllNews();
		assertEquals("Indian Express", newsList.get(0).getName());
		newsDAO.deleteNews(news.getNewsId());
	}

	@Test
	@Rollback(true)
	public void testDeleteNewsSuccess() {
		newsDAO.addNews(news);
		News newsData = newsDAO.getNewsById(news.getNewsId());
		boolean status = newsDAO.deleteNews(newsData.getNewsId());
		assertEquals(true, status);
	}

	@Test
	@Rollback(true)
	public void testGetNewsByNewsId() {
		newsDAO.addNews(news);
		News newsData = newsDAO.getNewsById(news.getNewsId());
		assertEquals(news, newsData);
		newsDAO.deleteNews(news.getNewsId());
	}

	@Test
	@Rollback(true)
	public void testGetAllNews() {
		News news1 = new News(1, "Indian Express", "Political", "CAA", "amendment", LocalDateTime.now());
		News news2 = new News(2, "The Hindu", "Sports", "Matches", "Score Details", LocalDateTime.now());

		newsDAO.addNews(news1);
		newsDAO.addNews(news2);

		List<News> newsList = newsDAO.getAllNews();
		assertEquals(2, newsList.size());

		newsDAO.deleteNews(news1.getNewsId());
		newsDAO.deleteNews(news2.getNewsId());
	}

	@Test
	@Rollback(true)
	public void testUpdateNews() {
		newsDAO.addNews(news);

		News newsData1 = newsDAO.getNewsById(news.getNewsId());
		newsData1.setName("Daily Thanthi");
		newsData1.setAuthor("Weather");
		newsData1.setDescription("Forecast");
		newsData1.setContent("Raining");
		newsData1.setPublishedAt(LocalDateTime.now());

		boolean status = newsDAO.updateNews(newsData1);
		News updatedNews = newsDAO.getNewsById(news.getNewsId());

		assertEquals("Raining", updatedNews.getContent());
		assertEquals(true, status);
		newsDAO.deleteNews(updatedNews.getNewsId());
	}
}