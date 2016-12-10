package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Ashutosh on 05-11-2016.
 */

@Document(collection = "bookmarks")
public class Bookmarks {

    private static final SecUserDetails userDetails = (SecUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final String userId = userDetails.getId();
    @NotNull(message = "DeckId can not be null")
    private long deckId;
    @NotNull(message = "CardId can not be null")
    private String cardId;
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

    public String getUserId() {
        return userId;
    }

    public long getDeckId() {
        return deckId;
    }

    public void setDeckId(long deckId) {
        this.deckId = deckId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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