package com.stackroute.newz.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.News;
import com.stackroute.newz.model.NewsSource;
import com.stackroute.newz.model.Reminder;
import com.stackroute.newz.model.UserNews;
import com.stackroute.newz.repository.NewsRepository;
import com.stackroute.newz.util.exception.NewsNotFoundException;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */

@Service
public class NewsServiceImpl implements NewsService {

	/*
	 * Autowiring should be implemented for the NewsDao and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	
	private NewsRepository newsRepository;
	private UserNews userNews = null;
	private Reminder reminder = null;
	private NewsSource newsSource = null;
	private List<News> newsList = null;
	private static final String NEWS_NOT_FOUND = "News not found";
	
	@Autowired
	public NewsServiceImpl(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	/*
	 * This method should be used to save a new news.
	 */
	@Override
	public boolean addNews(News news) {
		
		int count = 1;
		boolean status = false;
		news.setPublishedAt();
		
		reminder = new Reminder();
		newsSource = new NewsSource();
		userNews = new UserNews();
		newsList = new ArrayList<>();
		
		if (newsRepository.existsById(news.getAuthor())) {

			Optional<UserNews> optionalUserNews = newsRepository.findById(news.getAuthor());
			
			if (optionalUserNews.isPresent()) {
				newsList = optionalUserNews.get().getNewslist();
			}

			Iterator<News> iterator = newsList.iterator();
			News fetchedNews = new News();
			
			while (iterator.hasNext()) {
				fetchedNews = iterator.next();
			}
			
			news.setNewsId(fetchedNews.getNewsId() + count);
			reminder.setSchedule();
			reminder.setReminderId(news.getReminder().getReminderId());
			news.setReminder(reminder);
			newsSource.setNewsSourceName(news.getNewssource().getNewsSourceName());
			newsSource.setNewsSourceDesc(news.getNewssource().getNewsSourceDesc());
			newsSource.setNewsSourceCreatedBy(news.getNewssource().getNewsSourceCreatedBy());
			newsSource.setNewsSourceCreationDate();
			news.setNewssource(newsSource);
			newsList.add(news);
			userNews.setUserId(news.getAuthor());
			userNews.setNewslist(newsList);
			if (newsRepository.save(userNews) == userNews) {
				status = true;
			}
		} else {
			news.setNewsId(1);
			newsList.add(news);
			userNews.setUserId(news.getAuthor());
			userNews.setNewslist(newsList);

			UserNews addUserNews = newsRepository.insert(userNews);

			if (addUserNews != null) {
				status = true;
			}
		}
		return status;
	}

	/* This method should be used to delete an existing news. */
	
	public boolean deleteNews(String userId, int newsId) {
		
		boolean status = false;
		
		newsList = getAllNewsByUserId(userId);
		
		if(newsList!= null && !newsList.isEmpty()) {
			
			Iterator<News> iterator = newsList.listIterator();
			while (iterator.hasNext()) {

				News news = iterator.next();
				if (news.getNewsId() == newsId)
					iterator.remove();

			}
			
			userNews = new UserNews();
			userNews.setUserId(userId);
			userNews.setNewslist(newsList);
			newsRepository.save(userNews);
			status = true;
		}
		
		return status;
	}

	/* This method should be used to delete all news for a  specific userId. */
	
	public boolean deleteAllNews(String userId) throws NewsNotFoundException {
		
		boolean status = false;
		try {
			newsList = getAllNewsByUserId(userId);

			if (newsList != null) {

				UserNews fetchedUserNews = null;
	        	Optional<UserNews> existingUserNews = newsRepository.findById(userId);
	        	
	        	if(existingUserNews.isPresent()) {
	        		fetchedUserNews = existingUserNews.get();
	        
	        		if(fetchedUserNews != null) {
	        			newsRepository.delete(existingUserNews.get());
	        		    status = true;
	        		}
	        	}
			}
		} catch (Exception e) {
			throw new NewsNotFoundException(NEWS_NOT_FOUND);
		}

		return status;
	}

	/*
	 * This method should be used to update a existing news.
	 */

	public News updateNews(News news, int newsId, String userId) throws NewsNotFoundException {
		
		News updateNews = new News();
		List<News> updateNewsList = new ArrayList<>();
		userNews = new UserNews();

		try {

			newsList = getAllNewsByUserId(userId);
			if (newsList != null && !newsList.isEmpty()) {

				Iterator<News> iterator = newsList.listIterator();
				while (iterator.hasNext()) {

					updateNews = iterator.next();
					if (updateNews.getNewsId() == newsId) {
						updateNews.setNewsId(newsId);
						updateNews.setTitle(news.getTitle());
						updateNews.setContent(news.getContent());
						updateNews.setPublishedAt();
						updateNews.setAuthor(userId);
						updateNews.setReminder(news.getReminder());
					}

					updateNewsList.add(updateNews);
				}
				if (updateNews.getNewsId() != newsId) {
					throw new NewsNotFoundException(NEWS_NOT_FOUND);
				}

				userNews.setUserId(userId);
				userNews.setNewslist(updateNewsList);
				newsRepository.save(userNews);
			}
		} catch (Exception e) {
			throw new NewsNotFoundException(NEWS_NOT_FOUND);
		}

		return news;
	}

	/*
	 * This method should be used to get a news by newsId created by specific user
	 */

	public News getNewsByNewsId(String userId, int newsId) throws NewsNotFoundException {
		
		News news = new News();

		try {
			newsList = getAllNewsByUserId(userId);

			Iterator<News> iterator = newsList.listIterator();
			while (iterator.hasNext()) {

				news = iterator.next();
				if (news.getNewsId() == newsId)
					break;

			}

			if (news.getNewsId() != newsId) {
				throw new NewsNotFoundException(NEWS_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new NewsNotFoundException(NEWS_NOT_FOUND);
		}
		return news;
	}

	/*
	 * This method should be used to get all news for a specific userId.
	 */

	public List<News> getAllNewsByUserId(String userId) {
		
		List<News> userNewsList = new ArrayList<>();
		Optional<UserNews> userNews = newsRepository.findById(userId);
		
		if(userNews.isPresent()) {
			userNewsList = userNews.get().getNewslist();
		}
		return userNewsList;
	}

}
