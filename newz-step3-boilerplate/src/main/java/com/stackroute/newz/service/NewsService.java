package com.stackroute.newz.service;

import java.util.List;

import com.stackroute.newz.model.News;
import com.stackroute.newz.util.exception.NewsAlreadyExistsException;
import com.stackroute.newz.util.exception.NewsNotExistsException;

public interface NewsService {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */
	public News addNews(News news) throws NewsAlreadyExistsException;

	public News getNews(int newsId) throws NewsNotExistsException;

	public List<News> getAllNews();

	public News updateNews(News news) throws NewsNotExistsException;

	public void deleteNews(int news) throws NewsNotExistsException;

}
