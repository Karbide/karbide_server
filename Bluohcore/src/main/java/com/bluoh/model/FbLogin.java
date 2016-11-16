package com.bluoh.model;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * Created by Ashutosh on 14-11-2016.
 */
public class FbLogin {

    @NotNull(message = "Id cannot be null")
    private String id;
    @NotNull(message = "Picture cannot be null")
    private Picture picture;
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Gender cannot be null")
    private String gender;
    private String utm_source;
    private String utm_medium;
    private String utm_content;
    private String utm_campaign;
    private String utm_term;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", picture = " + picture + ", email = " + email + ", name = " + name + ", gender = " + gender + "]";
    }

}
