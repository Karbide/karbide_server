package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Ashutosh on 05-11-2016.
 */
@Document
public class Feedback {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userId = ((SecUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    @NotNull(message = "Subject can not be null")
    private String subject;
    @NotNull(message = "Name can not be null")
    private String name;
    @NotNull(message = "Number can not be null")
    @NumberFormat
    private long number;
    @NotNull(message = "Email can not be null")
    @Email
    private String email;
    @NotNull(message = "Content can not be null")
    private String content;
    @CreatedDate
    private Date createdTime;
    @LastModifiedDate
    private Date modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
