package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Card {

    @Id
    private String id;
    @JsonIgnore
    private long deckId;
    @JsonIgnore
    @NotBlank(message = "User Id cannot be blank")
    @CreatedBy
    private String userId;
    @NotBlank(message = "Title can not be empty.")
    private String title;
    @Size(min = 0, max = 256, message = "Content can not have more than 128 words")
    private String content;
    @JsonIgnore
    @NotBlank(message = "Author can not be empty.")
    private String author;
    @NotBlank(message = "Source url can not be empty.")
    private String url;

    @NotNull
    private Media media;
    @NotBlank(message = "Template can not be empty.")
    private String template;

    private String status;
    private Survey survey;

    @JsonIgnore
    @CreatedDate
    private Date createdTime;

    @LastModifiedDate
    @JsonIgnore
    private Date modifiedTime;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
                ", media=" + media +
                ", template='" + template + '\'' +
                ", status='" + status + '\'' +
                ", survey=" + survey +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}