package com.stackroute.newz.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.newz.config.ApplicationContextConfig;
import com.stackroute.newz.controller.NewsController;
import com.stackroute.newz.dao.NewsDAO;
import com.stackroute.newz.model.News;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class NewsControllerTest {

	LocalDateTime localDate = LocalDateTime.now();
	
	private MockMvc mockMvc;

	private News news;

	@Mock
	private NewsDAO newsDAO;

	@InjectMocks
	private NewsController newsController;

	@BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(newsController).build();
        
        news = new News(1, "NDTV", "NDTV", 
        		"The military blamed human error saying the Ukrainian jet had taken a sharp turn that brought it near a military base.",
        		"We expect Iran to assure its readiness for a full and open investigation", localDate);
    }



	@Test
	public void testIndexPage() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(forwardedUrl("index"));
	}

	@Test
	public void testAddNewsSuccess() throws Exception {
		when(newsDAO.addNews(any(News.class))).thenReturn(true);
		mockMvc.perform(post("/add")
				.param("name", news.getName())
				.param("author", news.getAuthor())
				.param("description", news.getDescription())
				.param("content", news.getContent()))
				.andExpect(status().isFound()).andExpect(redirectedUrl("/"));
	}
	
	@Test
	public void testAddNewsFailure() throws Exception {
		when(newsDAO.addNews(any(News.class))).thenReturn(false);
		mockMvc.perform(post("/add")
				.param("name", "")
				.param("author", "")
				.param("description", "")
				.param("content", ""))
				.andExpect(status().isOk()).andExpect(forwardedUrl("index"));
	}
	
	@Test
	public void testDeleteNewSuccess() throws Exception {
		when(newsDAO.deleteNews(news.getNewsId())).thenReturn(true);
		mockMvc.perform(get("/delete").param("newsId", "1"))
				.andExpect(redirectedUrl("/"));

	}
	
	@Test
	public void testUpdateNewsSuccess() throws Exception {
		when(newsDAO.updateNews(any(News.class))).thenReturn(true);
		mockMvc.perform(get("/update").param("newsId", "1"))
				.andExpect(forwardedUrl("index"));
		
		when(newsDAO.updateNews(any(News.class))).thenReturn(true);
		
		mockMvc.perform(post("/add")
				.param("newsId", "1")
				.param("name", news.getName())
				.param("author", news.getAuthor())
				.param("description", news.getDescription())
				.param("content", news.getContent()))
				.andExpect(status().isFound()).andExpect(redirectedUrl("/"));
	
	}
	
	@Test
	public void testUpdateNewsFailure() throws Exception {
		when(newsDAO.updateNews(any(News.class))).thenReturn(true);
		mockMvc.perform(get("/update").param("newsId", "1"))
				.andExpect(forwardedUrl("index"));
		
		when(newsDAO.updateNews(any(News.class))).thenReturn(true);
		
		mockMvc.perform(post("/add")
				.param("newsId", "1")
				.param("name", "")
				.param("author", "")
				.param("description", news.getDescription())
				.param("content", news.getContent()))
				.andExpect(status().isOk()).andExpect(forwardedUrl("index"));
	
	}

}
