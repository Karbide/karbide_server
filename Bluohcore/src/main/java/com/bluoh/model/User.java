package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Ashutosh on 11-10-2016.
 */

@Document
public class User {

    @Id
    private String id;
    private String username;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String gender;
    @JsonIgnore
    private Picture picture;
    private String password;
    @JsonIgnore
    private int Role;
    @JsonIgnore
    private String utm_source;
    @JsonIgnore
    private String utm_medium;
    @JsonIgnore
    private String utm_content;
    @JsonIgnore
    private String utm_campaign;
    @JsonIgnore
    private String utm_term;
    @JsonIgnore
    private String gcm_key;
    @CreatedDate
    private Date createdTime;
    @LastModifiedDate
    private Date modifiedTime;

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setRole(int role) {
        Role = role;
    }

    public String getUsername() {
        return username;
    }

    public int getRole() {
        return Role;
    }

    public String getUtm_source() {
        return utm_source;
    }

    public void setUtm_source(String utm_source) {
        this.utm_source = utm_source;
    }

    public String getUtm_medium() {
        return utm_medium;
    }

    public void setUtm_medium(String utm_medium) {
        this.utm_medium = utm_medium;
    }

    public String getUtm_content() {
        return utm_content;
    }

    public void setUtm_content(String utm_content) {
        this.utm_content = utm_content;
    }

    public String getUtm_campaign() {
        return utm_campaign;
    }

    public void setUtm_campaign(String utm_campaign) {
        this.utm_campaign = utm_campaign;
    }

    public String getUtm_term() {
        return utm_term;
    }

    public void setUtm_term(String utm_term) {
        this.utm_term = utm_term;
    }

    public String getGcm_key() {
        return gcm_key;
    }

    public void setGcm_key(String gcm_key) {
        this.gcm_key = gcm_key;
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
