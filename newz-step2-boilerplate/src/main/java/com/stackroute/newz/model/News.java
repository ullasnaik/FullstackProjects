package com.stackroute.newz.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * The class "News" will be acting as the data model for the news Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Entity
@Table(name = "News")
public class News implements Serializable
{

	private static final long serialVersionUID = 4L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int newsId;
	@Column
	private String name;
	@Column
	private String author;
	@Column
	private String description;
	@Column
	private String content;
	@Column
	private LocalDateTime publishedAt;
	
	public News() {	
	}

	public News(int newsId, String name, String author, String description, String content, LocalDateTime publishedAt) {
		this.newsId=newsId;
		this.name=name;
		this.author=author;
		this.description=description;
		this.content=content;
		this.publishedAt=publishedAt;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	@Override
	public String toString() {
		return "News{" +
				"newsId=" + newsId +
				", name='" + name + '\'' +
				", author='" + author + '\'' +
				", description='" + description + '\'' +
				", content='" + content + '\'' +
				", publishedAt=" + publishedAt +
				'}';
	}
}
