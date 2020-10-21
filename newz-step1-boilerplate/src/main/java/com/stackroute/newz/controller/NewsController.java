package com.stackroute.newz.controller;

import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
 * Annotate the class with @Controller annotation. @Controller annotation is used to mark
 * any java class as a controller so that Spring can recognize this class as a Controller
 */
@Controller
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;
    /*
     * From the problem statement, we can understand that the application
     * requires us to implement the following functionalities.
     *
     * 1. display the list of existing news from the collection. Each news object
     *    should contain News Id, title, author, description, content and created date.
     * 2. Add a new news which should contain the News Id, title, author, description, content.
     * 3. Delete an existing news.
     */

    /*
     * Get the application context from resources/beans.xml file using ClassPathXmlApplicationContext() class.
     * Retrieve the News object from the context.
     * Retrieve the NewsRepository object from the context.
     */



    /*Define a handler method to read the existing news by calling the getNewsList() method
     * of the NewsRepository class and add it to the ModelMap which is an implementation of Map
     * for use when building model data for use with views. it should map to the default URL i.e. "/" */


    @RequestMapping("/")
    public ModelAndView getNewsList() {
        List<News> newsList = newsRepository.getNewsList();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("newsList", newsList);
        return mav;
    }

    /*Define a handler method which will read the News data from request parameters and
     * save the news by calling the addNews() method of NewsRepository class. Please note
     * that the createdAt field should always be auto populated with system time and should not be accepted
     * from the user. Also, after saving the news, it should show the same along with existing
     * news elements. Hence, reading news has to be done here again.
     * This handler method should map to the URL "/saveNews".
     */
    @RequestMapping("/saveData")
    public String saveNews(@RequestParam(name = "newsId") int newsId,
                           @RequestParam(name = "title") String title,
                           @RequestParam(name = "author") String author,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "content") String content) {
        News news= new News();
        news.setNewsId(newsId);
        news.settitle(title);
        news.setAuthor(author);
        news.setDescription(description);
        news.setContent(content);
        newsRepository.addNews(news);
        return "redirect:/";
    }

    /* Define a handler method to delete an existing news by calling the deleteNews() method
     * of the NewsRepository class
     * This handler method should map to the URL "/deleteNews"
     */
    @RequestMapping("/deleteNews")
    public String getNewsList(@RequestParam(name = "newsId") int newsId) {
        newsRepository.deleteNews(newsId);
        return "redirect:/";
    }
}
