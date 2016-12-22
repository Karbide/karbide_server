package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Ashutosh on 22-12-2016.
 */
public class Cell {

    private String cellId;

    private List<String> tags;

    private List<String> categories;

    @NotEmpty(message = "Image Url cannot be empty")
    private String imageUrl;

    @NotNull(message = "feedUriPath can not be null")
    private String feedUriPath;

    @JsonIgnore
    private boolean isLive;

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFeedUriPath() {
        return feedUriPath;
    }

    public void setFeedUriPath(String feedUriPath) {
        this.feedUriPath = feedUriPath;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}