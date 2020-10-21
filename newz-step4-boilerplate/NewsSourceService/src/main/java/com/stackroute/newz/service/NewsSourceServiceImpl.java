package com.stackroute.newz.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.NewsSource;
import com.stackroute.newz.repository.NewsSourceRepository;
import com.stackroute.newz.util.exception.NewsSourceNotFoundException;

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
public class NewsSourceServiceImpl implements NewsSourceService {

	/*
	 * Autowiring should be implemented for the NewsDao and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	
	private NewsSourceRepository newsSourceRepository;
	
	private static final String NEWS_SOURCE_NOT_FOUND = "News Source not found";
	
	@Autowired
	public NewsSourceServiceImpl(NewsSourceRepository newsSourceRepository) {
		this.newsSourceRepository = newsSourceRepository;
	}

	/*
	 * This method should be used to save a newsSource.
	 */

	@Override
	public boolean addNewsSource(NewsSource newsSource) {

		NewsSource addNewsSource = null;
		boolean status = false;
		newsSource.setNewsSourceCreationDate();
		newsSource.setNewsSourceId(newsSourceRepository.findAll().size() + 1);
		addNewsSource = newsSourceRepository.insert(newsSource);

		if (addNewsSource != null) {
			status = true;
		}
		return status;
	}

	/* This method should be used to delete an existing newsSource. */

	@Override
	public boolean deleteNewsSource(int newsSourceId){
		
		boolean status = false;
		NewsSource newsSource = null;
		
		try {
			if (newsSourceRepository.findById(newsSourceId) != null) {
				newsSource = newsSourceRepository.findById(newsSourceId).get();
				newsSourceRepository.delete(newsSource);
				status = true;
			}
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	/* This method should be used to update an existing newsSource. */
	
	@Override
	public NewsSource updateNewsSource(NewsSource newsSource, int newsSourceId) throws NewsSourceNotFoundException {
		
		NewsSource fetchedNewsSource = null;
		
		try {
			fetchedNewsSource = newsSourceRepository.findById(newsSourceId).get();
			if (fetchedNewsSource != null) {
				
				fetchedNewsSource.setNewsSourceName(newsSource.getNewsSourceName());
				fetchedNewsSource.setNewsSourceDesc(newsSource.getNewsSourceDesc());
				fetchedNewsSource.setNewsSourceCreatedBy(newsSource.getNewsSourceCreatedBy());
				fetchedNewsSource.setNewsSourceCreationDate();
				newsSourceRepository.save(fetchedNewsSource);
			} else {
				throw new NewsSourceNotFoundException(NEWS_SOURCE_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new NewsSourceNotFoundException(NEWS_SOURCE_NOT_FOUND);
		}
		return fetchedNewsSource;
	}

	/* This method should be used to get a specific newsSource for an user. */

	@Override
	public NewsSource getNewsSourceById(String userId, int newsSourceId) throws NewsSourceNotFoundException {
		
		NewsSource newsSource = null;
		try {

			Iterator<NewsSource> iterator = newsSourceRepository.findAllNewsSourceByNewsSourceCreatedBy(userId).listIterator();

			while (iterator.hasNext()) {
				newsSource = iterator.next();
				
				if(newsSource.getNewsSourceId() == newsSourceId) {
					break;
				}
			}
			
			if(newsSource.getNewsSourceId() != newsSourceId) {
				throw new NewsSourceNotFoundException(NEWS_SOURCE_NOT_FOUND);
			}

		} catch (Exception e) {
			return newsSource;
		}
		return newsSource;
	}

	
	 /* This method should be used to get all newsSource for a specific userId.*/

	@Override
	public List<NewsSource> getAllNewsSourceByUserId(String createdBy) {
		return newsSourceRepository.findAllNewsSourceByNewsSourceCreatedBy(createdBy);
	}

}
