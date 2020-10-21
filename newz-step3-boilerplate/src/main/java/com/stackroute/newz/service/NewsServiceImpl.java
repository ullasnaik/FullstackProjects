package com.stackroute.newz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;
import com.stackroute.newz.service.NewsService;
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
	private  NewsRepository newsRepository;

	/*
	 * Add a new news. Throw NewsAlreadyExistsException if the news with specified
	 * newsId already exists.
	 */
	public News addNews(News news) throws NewsAlreadyExistsException {
		if(null!=newsRepository.getOne(news.getNewsId())){
			throw new NewsAlreadyExistsException();
		}
		return newsRepository.save(news);
	}

	/*
	 * Retrieve an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public News getNews(int newsId) throws NewsNotExistsException {
		Optional<News> optionalNews = newsRepository.findById(newsId);
		if(optionalNews.isEmpty()){
			throw new NewsNotExistsException();
		}
		return optionalNews.get();
	}

	/*
	 * Retrieve all existing news
	 */
	public List<News> getAllNews() {

		return newsRepository.findAll();
	}

	
	/*
	 * Update an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public News updateNews(News news) throws NewsNotExistsException {
		if(null==newsRepository.getOne(news.getNewsId())){
			throw new NewsNotExistsException();
		}
		return newsRepository.saveAndFlush(news);
	}

	/*
	 * Delete an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public void deleteNews(int newsId) throws NewsNotExistsException {
		if(null==newsRepository.getOne(newsId)){
			throw new NewsNotExistsException();
		}
		newsRepository.deleteById(newsId);
	}

}
