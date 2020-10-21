package com.stackroute.newz.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


/*
 * The class "News" will be acting as the data model for the News Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */

@Entity
public class News {

	/*
	 * This class should have ten fields
	 * (newsId,title,author,description, publishedAt, content, url, urlToImage,user,reminder). 
	 * Out of these ten fields, the
	 * field newsId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. 
	 * annotate user field with @ManyToOne and reminder field as @OneToOne and add
	 * @JsonIgnore for both of them.
	 * 
	 * The data type for publishedAt field should be LocalDateTime. 
	 * Please add @JsonSerialize(using = ToStringSerializer.class) for this field
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int newsId;
	private String title;
	private String author;
	private String description;
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime publishedAt;
	private String content;
	private String url;
	private String urlToImage;
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserProfile user;
	@OneToOne
	private Reminder reminder;
	
	
	public News(int newsId, String title, String author, String description, LocalDateTime publishedAt, String content,
			String url, String urlToImage, UserProfile user, Reminder reminder) {
		
		
	}

	/**
	 * @return the newsID
	 */
	public News() {
		
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public Reminder getReminder() {
		return reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}
}
