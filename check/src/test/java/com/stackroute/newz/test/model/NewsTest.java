package com.stackroute.newz.test.model;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.stackroute.newz.model.News;

class NewsTest {

	private News news;

	@BeforeEach
	public void setUp() throws Exception {
		
		news = new News();
		
		news.setNewsId(1);
		news.setTitle("breaking news");
		news.setAuthor("johnsmith");
		news.setDescription("sample description");
		news.setContent("sample content");
		news.setPublishedAt(LocalDateTime.now());
		news.setUrl(null);
		news.setUrlToImage(null);
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void Beantest() {
		BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
        beanTester.testBean(News.class);


	}

}
