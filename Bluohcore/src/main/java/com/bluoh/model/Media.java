package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Ashutosh on 27-09-2016.
 */

@Document
public class Media {

    @Id
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @NotBlank
    private String mediaType;
    @NotBlank
    private String mediaUrl;
    @NotBlank
    private String mediaCredit;

    @JsonIgnore
    @CreatedDate
    private Date createdTime;

    @JsonIgnore
    @LastModifiedDate
    private Date modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return mediaType;
    }

    public void setType(@SuppressWarnings("SameParameterValue") String type) {
        this.mediaType = type;
    }

    public String getUrl() {
        return mediaUrl;
    }

    public void setUrl(String url) {
        this.mediaUrl = url;
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

    public String getSource() {
        return mediaCredit;
    }

    public void setSource(String source) {
        this.mediaCredit = source;
    }
}