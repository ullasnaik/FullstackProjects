package com.stackroute.newz.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.newz.controller.NewsController;
import com.stackroute.newz.repository.NewsRepository;

@SuppressWarnings("PMD")
@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:beans.xml"})
public class NewsControllerTest {
    @Autowired
    private static MockMvc mockMvc;

    @Mock
    private NewsRepository newsRepository;

    @InjectMocks
    private static NewsController newsController = new NewsController();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(newsController).build();
    }

    @Test
    void testGetHomePage() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"))
                .andExpect(forwardedUrl("index"));
    }

    @Test
    void saveData() throws Exception {
        mockMvc.perform(post("/saveData").param("newsId", "1").param("title", "Cricket").param("author", "Sachin")
                .param("description", "This is Cricket match between India vs Australia").param("content", "This is First ODI between India and Australia")).andExpect(redirectedUrl("/"));

    }

    @Test
    public void testDeleteNews() throws Exception {
        when(newsRepository.deleteNews(1)).thenReturn(true);
        mockMvc.perform(get("/deleteNews").param("newsId", "1")).andExpect(redirectedUrl("/"));
    }

    @Test
    public void testAddNewsEmptyTitleFailure() throws Exception {
        mockMvc.perform(post("/saveData").param("newsId", "1").param("title", "").param("author", "Sachin")
                .param("description", "This is Cricket match between India vs Australia").param("content", "This is First ODI between India and Australia")).andExpect(redirectedUrl("/"));
    }

    @Test
    public void testAddNewsEmptyAuthorFailure() throws Exception {
        mockMvc.perform(post("/saveData").param("newsId", "1").param("title", "Cricket").param("author", "")
                .param("description", "This is Cricket match between India vs Australia").param("content", "This is First ODI between India and Australia")).andExpect(redirectedUrl("/"));
    }

    @Test
    public void testAddNewsEmptyDescriptionFailure() throws Exception {
        mockMvc.perform(post("/saveData").param("newsId", "1").param("title", "Cricket").param("author", "Sachin")
                .param("description", "").param("content", "This is First ODI between India and Australia")).andExpect(redirectedUrl("/"));
    }

    @Test
    public void testAddNewsEmptyContentFailure() throws Exception {
        mockMvc.perform(post("/saveData").param("newsId", "1").param("title", "Cricket").param("author", "Sachin")
                .param("description", "This is Cricket match between India vs Australia").param("content", "")).andExpect(redirectedUrl("/"));
    }


}