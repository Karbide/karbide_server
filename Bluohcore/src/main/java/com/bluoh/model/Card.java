package com.bluoh.model;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;

@Document
public final class Card {

	@Id
	private ObjectId id;
	@NotBlank(message="User Id cannot be blank")
	@CreatedBy
	private String userId;
	@NotBlank(message = "Title can not be empty.")
	private String title;
	@Size(min = 0, max = 128, message = "Content can not have more than 128 words")
	private String content;
	@NotBlank(message = "Author can not be empty.")
	private String author;
	@NotBlank(message = "Source can not be empty.")
	private String source;
	@NotNull(message = "Category can not be empty.")
	private String category[];
	@NotNull(message = "Tags can not be empty.")
	private String tags[];
	@NotBlank(message = "Image can not be empty.")
	private String imageUrl;
	private String template;
	private String status;
	@CreatedDate
	private Date createdTime;
	@LastModifiedDate
	private Date modifiedTime;
	
	public Card(){	
	}

	public Card(ObjectId id,String userId, String title, String content, String author, String source, String[] category, String[] tags, String imageUrl, String template, String status, Date createdTime, Date modifiedTime) {
		super();
		this.id= id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.author = author;
		this.source = source;
		this.category = category;
		this.tags = tags;
		this.imageUrl = imageUrl;
		this.template = template;
		this.status = status;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public String getId() {
		return id.toString();
	}

	public void setId(String id) {
		this.id = new ObjectId(id);
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content + ", author=" + author + ", source=" + source + ", category=" + Arrays.toString(category) + ", tags="
				+ Arrays.toString(tags) + ", imageUrl=" + imageUrl + ", template=" + template + ", status=" + status + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
	}
}