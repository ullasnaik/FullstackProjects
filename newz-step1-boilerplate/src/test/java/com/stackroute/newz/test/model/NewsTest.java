package com.stackroute.newz.test.model;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.stackroute.newz.model.News;

@SuppressWarnings("PMD")
class NewsTest {

    private static News news;

    @BeforeAll
    public static void setUp() throws  Exception {
        news = new News();
        news.setNewsId(1);
        news.settitle("Cricket");
        news.setAuthor("Sachin");
        news.setDescription("This is Cricket match between India vs Australia");
        news.setPublishedAt(LocalDateTime.now());
        news.setContent("This is First ODI between India and Australia");
    }
    @Test
    public void testBean() {

        BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
        beanTester.testBean(News.class);
    }

    @Test
    public void testnewsIdShouldNotBeEmpty() {
        assertTrue(news.getNewsId()==1,"NewsId Should be 1");

    }
    @Test
    public void testnewsTitleShouldNotBeEmpty() {
        assertTrue(news.getTitle().equalsIgnoreCase("Cricket"),"News Title Should be Cricket");
    }
    @Test
    public void testNewsAuthorShouldNotBeEmpty() {
        assertTrue(news.getAuthor().equalsIgnoreCase("Sachin"),"News Author Should be Sachin");
    }

    @Test
    public void testNewsDescriptionShouldNotBeEmpty() {
        assertTrue(news.getDescription().equalsIgnoreCase("This is Cricket match between India vs Australia"),"New Description Should be This is Cricket match between India vs Austrila");
    }
    @Test
    public void testNewsContentShouldNotBeEmppty() {
        assertTrue(news.getContent().equalsIgnoreCase("This is First ODI between India and Australia"),"News Content Should be This is First ODI between India and Australia");
    }
}