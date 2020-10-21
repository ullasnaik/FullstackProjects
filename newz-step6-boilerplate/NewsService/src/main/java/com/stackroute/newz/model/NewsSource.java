package com.stackroute.newz.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NewsSource {
	
	/*
	 * This class should have five fields
	 * (newssourceId,newssourceName,newssourceDesc,newssourceCreatedBy,newssourceCreationDate).
	 * This class should also contain the getters and setters for the 
	 * fields along with the parameterized	constructor and toString method.
	 * The value of newssourceCreationDate should not be accepted from the user but should be
	 * always initialized with the system date.
	 */
	@Id
	private String newssourceId;
	
	private String newssourceName;
	
	private String newssourceDesc;
	
	private String newssourceCreatedBy;
	
	private LocalDateTime newssourceCreationDate;
	
	public NewsSource() {
		
	}
	
	public NewsSource(String newssourceId, String newssourceName, String newssourceDesc, String newssourceCreatedBy,
			LocalDateTime newssourceCreationDate) {
		this.newssourceId = newssourceId;
		this.newssourceName = newssourceName;
		this.newssourceDesc = newssourceDesc;
		this.newssourceCreatedBy = newssourceCreatedBy;
		this.newssourceCreationDate = newssourceCreationDate;
	}

	public String getNewssourceId() {
		return newssourceId;
	}

	public void setNewssourceId(String newssourceId) {
		this.newssourceId = newssourceId;
	}

	public String getNewssourceName() {
		return newssourceName;
	}

	public void setNewssourceName(String newssourceName) {
		this.newssourceName = newssourceName;
	}

	public String getNewssourceDesc() {
		return newssourceDesc;
	}

	public void setNewssourceDesc(String newssourceDesc) {
		this.newssourceDesc = newssourceDesc;
	}

	public String getNewssourceCreatedBy() {
		return newssourceCreatedBy;
	}

	public void setNewssourceCreatedBy(String newssourceCreatedBy) {
		this.newssourceCreatedBy = newssourceCreatedBy;
	}

	public LocalDateTime getNewssourceCreationDate() {
		return newssourceCreationDate;
	}

	public void setNewssourceCreationDate() {
		this.newssourceCreationDate = LocalDateTime.now();;
	}

	public String getNewsSourceId() {
		return newssourceId;
	}

	public void setNewsSourceId(String newssourceId) {
		this.newssourceId = newssourceId;
	}

	public String getNewsSourceName() {
		return newssourceName;
	}

	public void setNewsSourceName(String newssourceName) {
		this.newssourceName = newssourceName;
	}

	public String getNewsSourceDesc() {
		return newssourceDesc;
	}

	public void setNewsSourceDesc(String newssourceDesc) {
		this.newssourceDesc = newssourceDesc;
	}

	public String getNewsSourceCreatedBy() {
		return newssourceCreatedBy;
	}

	public void setNewsSourceCreatedBy(String newssourceCreatedBy) {
		this.newssourceCreatedBy = newssourceCreatedBy;
	}

	public LocalDateTime getNewsSourceCreationDate() {
		return newssourceCreationDate;
	}

	public void setNewsSourceCreationDate() {
		this.newssourceCreationDate = LocalDateTime.now();;
	}

	public void setNewsSourceId(int newssourceId) {
		this.newssourceId = Integer.toString(newssourceId) ;
	}
	public void setNewssourceId(int newssourceId) {
		this.newssourceId = Integer.toString(newssourceId);
	}
	@Override
	public String toString() {
		return "Newssource [newssourceId=" + newssourceId + ", newssourceName=" + newssourceName + ", newssourceDesc="
				+ newssourceDesc + ", newssourceCreatedBy=" + newssourceCreatedBy + ", newssourceCreationDate="
				+ newssourceCreationDate + "]";
	}
}
