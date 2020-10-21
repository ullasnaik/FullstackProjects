package com.stackroute.newz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;
import com.stackroute.newz.util.exception.NewsAlreadyExistsException;
import com.stackroute.newz.util.exception.NewsNotExistsException;


/*
 * This class is implementing the NewsService interface. This class has to be annotated with 
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus 
 * clarifying it's role.
 * 
 * */
@Service
public class NewsServiceImpl implements NewsService {

	/*
	 * Autowiring should be implemented for the NewsRepository.
	 */
	
	

	@Autowired
	    private NewsRepository newsRepository;
	/*
	 * Add a new news. Throw NewsAlreadyExistsException if the news with specified
	 * newsId already exists.
	 */
	public News addNews(News news) throws NewsAlreadyExistsException {
		//Optional<News> newsExist = newsRepository.findById(news.getNewsId());
		News newsElm = newsRepository.getOne(news.getNewsId());
		if(newsElm!=null) {
			throw new NewsAlreadyExistsException();
		}else {
			news = newsRepository.save(news);
			return news;
		}
	}

	/*
	 * Retrieve an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public News getNews(int newsId) throws  NewsNotExistsException{
		
		Optional<News> newsExist = newsRepository.findById(newsId);
		//News newsElm = newsRepository.getOne(newsId);
		if(newsExist!=null && newsExist.isPresent()) {
			News news = newsExist.get();
			return news;
		}else {
			throw new NewsNotExistsException();
			
		}
	}

	/*
	 * Retrieve all existing news
	 */
	public List<News> getAllNews() {

		 List<News> NewsList = newsRepository.findAll();
         
	        if(NewsList!=null && NewsList.size() > 0) {
	            return NewsList;
	        } else {
	            return new ArrayList<News>();
	        }
	}

	
	/*
	 * Update an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public News updateNews(News news) throws NewsNotExistsException {
		//Optional<News> newsExist = newsRepository.findById(news.getNewsId());
		News newsElm = newsRepository.getOne(news.getNewsId());
		if(newsElm!=null) {
			News newsEntity = newsRepository.saveAndFlush(news);
            return newsEntity;
		}else {
			throw new NewsNotExistsException();
			
		}
	}

	/*
	 * Delete an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public void deleteNews(int newsId) throws NewsNotExistsException {

		//Optional<News> newsExist = newsRepository.findById(newsId);
		News newsElm = newsRepository.getOne(newsId);
		if(newsElm!=null) {
			newsRepository.deleteById(newsId);
		}else {
			throw new NewsNotExistsException();
			
		}
	}

}
