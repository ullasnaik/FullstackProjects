package com.stackroute.newz.model;

import java.time.LocalDateTime;

/* 
 * Annotate the class with @Component annotation. 
 * @Component annotation is used to crete singleton instance of of the class
 *
 */


/*
 * The class "News" will be acting as the data model for the News data in the ArrayList.
 */
public class News {
	
	/*
	 * This class should have five fields (newsId, title, author,
	 * description, content and publishedAt). This class should also contain the getters and
	 * setters for the fields. The value of publishedAt should not be accepted from
	 * the user but should be always initialized with the system date
	 */

    private int newsId;
    private String title;
    private String author;
    private String description;
    private String content;
    private LocalDateTime publishedAt;
	
    public News() {
        super();
    }
    /* All the getters/setters definition should be implemented here */

    public int getNewsId() {
        return this.newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId=newsId;
    }

    public String getTitle() {
        return this.title;
    }

    public void settitle(String title) {
        this.title=title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author=author;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public LocalDateTime getPublishedAt() {
        return this.publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt=publishedAt;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content=content;
    }

    /* Override the toString() method */

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", publishedAt=" + publishedAt +
                '}';
    }
}
