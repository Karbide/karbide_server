package com.bluoh.model;

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

@Document(collection = "deck_activity")
public class DeckActivity {

    private static SecUserDetails userDetails = (SecUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    @Id
    private String id;
    private String userId = userDetails.getId();
    private long deckId;
    @NotNull(message = "CardId can not be null")
    private String cardId;
    @NotNull(message = "Activity can not be null")
    private String activity;
    @CreatedDate
    private Date createdTime;
    @LastModifiedDate
    private Date updatedTime;

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

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}