package com.stackroute.newz.test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;

@SuppressWarnings("PMD")
class NewsRepositoryTest {

   private NewsRepository newsRepository;


    @BeforeEach
    void setUp() {
        newsRepository = new NewsRepository();


    }

    @AfterEach
    void tearDown() {
        News news = null;
    }

    @Test
    public void testAddNews() {
        assertTrue(newsRepository != null);
        News news = new News();
        news.setNewsId(1);
        news.settitle("Cricket");
        news.setAuthor("Sachin");
        news.setDescription("This is Cricket match between India vs Australia");
        news.setContent("This is First ODI between India and Australia");

        newsRepository.addNews(news);
        assertNotNull(newsRepository.getAllNews().stream().filter(newss -> news.getNewsId() == news.getNewsId()).findAny().orElse(null));
    }
    @Test
    public void testDeletenews() {
        assertTrue(newsRepository != null);
        News news = new News();
        news.setNewsId(1);
        news.settitle("Cricket");
        news.setAuthor("Sachin");
        news.setPublishedAt(LocalDateTime.now());
        news.setDescription("This is Cricket match between India vs Australia");
        news.setContent("This is First ODI between India and Australia");
       newsRepository.addNews(news);
       newsRepository.deleteNews(news.getNewsId());

        assertNull(newsRepository.getAllNews().stream().filter(newss -> news.getNewsId() == news.getNewsId()).findAny().orElse(null));
    }

    @Test
    public void testGetAllnewss() {
        News news = new News();
        news.setNewsId(1);
        news.settitle("Cricket");
        news.setAuthor("Sachin");
        news.setDescription("This is Cricket match between India vs Australia");
        news.setContent("This is First ODI between India and Australia");
        news.setPublishedAt(LocalDateTime.now());
        // saving the news
        newsRepository.addNews(news);
        News news1 = new News();

        news1.setNewsId(2);
        news1.settitle("Cricket");
        news1.setAuthor("Sachin");
        news1.setDescription("This is Cricket match between India vs Australia");
        news1.setContent("This is First ODI between India and Australia");
        news1.setPublishedAt(LocalDateTime.now());
        newsRepository.addNews(news1);
   
        assertEquals(2,newsRepository.getAllNews().size());
    }

}