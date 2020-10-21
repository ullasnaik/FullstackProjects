package com.stackroute.newz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.newz.model.News;
import com.stackroute.newz.service.NewsService;
import com.stackroute.newz.util.exception.NewsNotFoundException;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */
@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

	/*
	 * Autowiring should be implemented for the NewsService. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword
	 */

	private NewsService newsService;

	@Autowired
	public NewsController(NewsService newsService) {
		this.newsService = newsService;
	}

	/*
	 * Define a handler method which will create a specific news by reading the
	 * Serialized object from request body and save the news details in the
	 * database.This handler method should return any one of the status messages
	 * basis on different situations: 
	 * 1. 201(CREATED) - If the news created successfully. 
	 * 2. 409(CONFLICT) - If the newsId conflicts with any existing user.
	 * 
	 * This handler method should map to the URL "/api/v1/news" using HTTP POST method
	 */
	@PostMapping
	public ResponseEntity<?> addNews(@RequestBody News news) {

		ResponseEntity<?> responseEntity = null;

		if (newsService.addNews(news)) {
			responseEntity = new ResponseEntity<>("News added successfully", HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>("News adition error", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	/*
	 * Define a handler method which will delete a news from a database.
	 * This handler method should return any one of the status messages basis 
	 * on different situations: 
	 * 1. 200(OK) - If the news deleted successfully from database. 
	 * 2. 404(NOT FOUND) - If the news with specified newsId is not found.
	 *
	 * This handler method should map to the URL "/api/v1/news/{userId}/{newsId}" 
	 * using HTTP Delete method where "userId" should be replaced by a valid userId 
	 * without {} and "newsId" should be replaced by a valid newsId 
	 * without {}.
	 * 
	 */
	@DeleteMapping("/{userId}/{newsId}")
	public ResponseEntity<?> deleteNews(@PathVariable String userId, @PathVariable() int newsId) {
		ResponseEntity<?> responseEntity = null;

		if (newsService.deleteNews(userId, newsId)) {
			responseEntity = new ResponseEntity<>("News deleted successfully", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>("Something went wrong while deleting news.Please try again", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	/*
	 * Define a handler method which will delete all the news of a specific user from 
	 * a database. This handler method should return any one of the status messages 
	 * basis on different situations: 
	 * 1. 200(OK) - If the newsId deleted successfully from database. 
	 * 2. 404(NOT FOUND) - If the note with specified newsId is not found.
	 *
	 * This handler method should map to the URL "/api/v1/news/{userId}" 
	 * using HTTP Delete method where "userId" should be replaced by a valid userId 
	 * without {} and "newsid" should be replaced by a valid newsId 
	 * without {}.
	 * 
	 */
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteAllNews(@PathVariable() String userId) {

		ResponseEntity<?> responseEntity = null;

		try {
			newsService.deleteAllNews(userId);
			responseEntity = new ResponseEntity<>("News deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Something went wrong while deleting news.Please try again", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	/*
	 * Define a handler method which will update a specific news by reading the
	 * Serialized object from request body and save the updated news details in a
	 * database. 
	 * This handler method should return any one of the status messages
	 * basis on different situations: 
	 * 1. 200(OK) - If the news updated successfully.
	 * 2. 404(NOT FOUND) - If the news with specified newsId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/news/{userId}/{newsId}" using 
	 * HTTP PUT method where "userId" should be replaced by a valid userId 
	 * without {} and "newsid" should be replaced by a valid newsId without {}.
	 * 
	 */
	@PutMapping("/{userId}/{newsId}")
	public ResponseEntity<?> updateNews(@PathVariable() String userId, @PathVariable() int newsId,
			@RequestBody News news) {

		ResponseEntity<?> responseEntity = null;

		try {
			News updatedNews = newsService.updateNews(news, newsId, userId);
			responseEntity = new ResponseEntity<>(updatedNews, HttpStatus.OK);
		} catch (NewsNotFoundException newsNotFoundException) {
			responseEntity = new ResponseEntity<>(newsNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}

		return responseEntity;
	}
	
	/*
	 * Define a handler method which will get us the specific news by a userId.
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the news found successfully. 
	 * 2. 404(NOT FOUND) - If the news with specified newsId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/news/{userId}/{newsId}" 
	 * using HTTP GET method where "userId" should be replaced by a valid userId 
	 * without {} and "newsid" should be replaced by a valid newsId without {}.
	 * 
	 */
	@GetMapping("{userId}/{newsId}")
	public ResponseEntity<?> getNewsById(@PathVariable() String userId, @PathVariable() int newsId) {
		ResponseEntity<?> responseEntity = null;
		try {
			News news = newsService.getNewsByNewsId(userId, newsId);
			responseEntity = new ResponseEntity<>(news, HttpStatus.OK);
		} catch (NewsNotFoundException newsNotFoundException) {
			responseEntity = new ResponseEntity<>(newsNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	/*
	 * Define a handler method which will show details of all news created by specific 
	 * user. This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the news found successfully. 
	 * 2. 404(NOT FOUND) - If the news with specified newsId is not found.
	 * This handler method should map to the URL "/api/v1/news/{userId}" using HTTP GET method
	 * where "userId" should be replaced by a valid userId without {}.
	 * 
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllNewsByUserId(@PathVariable() String userId) {
		ResponseEntity<?> responseEntity = null;
		List<News> userNews = newsService.getAllNewsByUserId(userId);

		if (userNews != null) {
			responseEntity = new ResponseEntity<>(userNews, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>("News not found in list", HttpStatus.NOT_FOUND);
		}

		return responseEntity;
	}


}
