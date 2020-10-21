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

import com.stackroute.newz.model.NewsSource;
import com.stackroute.newz.service.NewsSourceService;
import com.stackroute.newz.util.exception.NewsSourceNotFoundException;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */

@RestController
@RequestMapping("/api/v1/newssource")
public class NewsSourceController {

	/*
	 * Autowiring should be implemented for the NewsService. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword
	 */
	
	private NewsSourceService newsSourceService;
	
	@Autowired
	public NewsSourceController(NewsSourceService newsSourceService) {
		this.newsSourceService = newsSourceService;
	}


	/*
	 * Define a handler method which will create a specific newssource by reading the
	 * Serialized object from request body and save the newssource details in the
	 * database.This handler method should return any one of the status messages
	 * basis on different situations: 
	 * 1. 201(CREATED) - If the newssource created successfully. 
	 * 2. 409(CONFLICT) - If the newssourceId conflicts with any existing user.
	 * 
	 * This handler method should map to the URL "/api/v1/newssource" using HTTP POST method
	 */

	@PostMapping
	public ResponseEntity<?> addNewssource(@RequestBody NewsSource newsSource) {

		ResponseEntity<?> responseEntity = null;
		
		boolean addStatus = newsSourceService.addNewsSource(newsSource);

		if (addStatus) {
			responseEntity = new ResponseEntity<>(newsSource, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>("Something went wrong while adding news source.Please try again", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	/*
	 * Define a handler method which will delete a newssource from a database.
	 * This handler method should return any one of the status messages basis 
	 * on different situations: 
	 * 1. 200(OK) - If the newssource deleted successfully from database. 
	 * 2. 404(NOT FOUND) - If the newssource with specified newsId is not found.
	 *
	 * This handler method should map to the URL "/api/v1/newssource/{newssourceId}" 
	 * using HTTP Delete method where "userId" should be replaced by a valid userId 
	 * without {} and "newssourceId" should be replaced by a valid newsId 
	 * without {}.
	 * 
	 */
	
	@DeleteMapping("/{newsSourceId}")
    public ResponseEntity<?> deleteNewssource(@PathVariable() int newsSourceId) {
    	ResponseEntity<?> responseEntity = null;

		if (newsSourceService.deleteNewsSource(newsSourceId)) {
			responseEntity = new ResponseEntity<>("Successfully deleted News Source", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>("Something went wrong while deleting news source.Please try again", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
    }
	
	/*
	 * Define a handler method which will update a specific newssource by reading the
	 * Serialized object from request body and save the updated newssource details in a
	 * database. This handler method should return any one of the status messages
	 * basis on different situations: 
	 * 1. 200(OK) - If the newssource updated successfully.
	 * 2. 404(NOT FOUND) - If the newssource with specified newssourceId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/newssource/{newssourceId}" using 
	 * HTTP PUT method where "newssourceId" should be replaced by a valid newssourceId
	 * without {}.
	 * 
	 */
	@PutMapping("/{newsSourceId}")
    public ResponseEntity<?> updateNewsSource(@PathVariable int newsSourceId, @RequestBody NewsSource newsSource) {
		ResponseEntity<?> responseEntity = null;

		try {
			NewsSource updateNewsSource = newsSourceService.updateNewsSource(newsSource, newsSourceId);
			responseEntity = new ResponseEntity<>(updateNewsSource, HttpStatus.OK);
		} catch (NewsSourceNotFoundException newsSourceNotFoundException) {
			responseEntity = new ResponseEntity<>(newsSourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
        return responseEntity;
    }
	
	/*
	 * Define a handler method which will get us the specific newssource by a userId.
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the newssource found successfully. 
	 * 2. 404(NOT FOUND) - If the newssource with specified newsId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/newssource/{userId}/{newssourceId}" 
	 * using HTTP GET method where "userId" should be replaced by a valid userId 
	 * without {} and "newssourceId" should be replaced by a valid newsId without {}.
	 * 
	 */
	
	@GetMapping("/{userId}/{newsSourceId}")
    public ResponseEntity<?> getNewsSourceById(@PathVariable String userId,@PathVariable int newsSourceId) {
    	ResponseEntity<?> responseEntity = null;
		try {
			NewsSource newssource = newsSourceService.getNewsSourceById(userId, newsSourceId);
			responseEntity = new ResponseEntity<>(newssource, HttpStatus.OK);
		} catch (NewsSourceNotFoundException newsSourceNotFoundException) {
			responseEntity = new ResponseEntity<>(newsSourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;	
    }
	
	/*
	 * Define a handler method which will show details of all newssource created by specific 
	 * user. This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the newssource found successfully. 
	 * 2. 404(NOT FOUND) - If the newssource with specified newsId is not found.
	 * This handler method should map to the URL "/api/v1/newssource/{userId}" using HTTP GET method
	 * where "userId" should be replaced by a valid userId without {}.
	 * 
	 */

	@GetMapping("/{userId}")
    public ResponseEntity<?> getAllNewsSourceByUserId(@PathVariable String userId) {
    	
		ResponseEntity<?> responseEntity = null;
		List<NewsSource> newsSourcesList = newsSourceService.getAllNewsSourceByUserId(userId);
		
		if (newsSourcesList != null) {
			responseEntity = new ResponseEntity<>(newsSourcesList, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>("News Sources not found in list", HttpStatus.OK);
		}
		return responseEntity;
    }
    
}
