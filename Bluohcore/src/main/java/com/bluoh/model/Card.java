package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Document
public final class Card {

	@Id
	private String id;
	private long deckId;
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
	private Categories category;
	@NotNull(message = "Tags can not be empty.")
	private Tags tags;
	@NotNull
	private Media media;
	private Approver approver;
	@NotBlank(message = "Image can not be empty.")
	private String template;
	private String status;
	private Survey survey;
	@CreatedDate
	@JsonIgnore
	private Date createdTime;
	@LastModifiedDate
	@JsonIgnore
	private Date modifiedTime;
	
	public Card(){	
	}

	public Card(String id, long deckId, String userId, String title, String content, String author, String source, Categories category, Tags tags, Media media, Approver approver, String template, String status, Survey survey, Date createdTime, Date modifiedTime) {
		this.id = id;
		this.deckId = deckId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.author = author;
		this.source = source;
		this.category = category;
		this.tags = tags;
		this.media = media;
		this.approver = approver;
		this.template = template;
		this.status = status;
		this.survey = survey;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getDeckId() {
		return deckId;
	}

	public void setDeckId(long deckId) {
		this.deckId = deckId;
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

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Approver getApprover() {
		return approver;
	}

	public void setApprover(Approver approver) {
		this.approver = approver;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
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

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
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
		return "Card{" +
				"id='" + id + '\'' +
				", deckId=" + deckId +
				", userId='" + userId + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", author='" + author + '\'' +
				", source='" + source + '\'' +
				", category=" + category +
				", tags=" + tags +
				", media=" + media +
				", approver=" + approver +
				", template='" + template + '\'' +
				", status='" + status + '\'' +
				", survey=" + survey +
				", createdTime=" + createdTime +
				", modifiedTime=" + modifiedTime +
				'}';
	}
}