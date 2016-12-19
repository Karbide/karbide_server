package com.bluoh.model;

import com.bluoh.utils.annotations.ValidCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ashutosh on 25-09-2016.
 */
@Document
public class Deck {

    private static SecUserDetails userDetails = (SecUserDetails) SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long deckId;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userId = userDetails.getId();

    @NotBlank(message = "Type can not be empty.")
    private String type;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String authorImage = userDetails.getUserImage();

    private String author = userDetails.getName();

    @NotBlank(message = "Author Handle can not be empty.")
    private String authorHandle;

    @NotNull(message = "Category can not be empty.")
    @ValidCategory(message = "Category(s) does not exist")
    private List<String> categories;

    @NotNull(message = "Tags can not be empty.")
    private List<String> tags;

    private Approver approver;

    private Date publishedDate;

    private String status;

    private int likes;

    private int dislikes;
    @JsonIgnore
    @Field(value = "cards")
//    @JsonProperty("cards")
    private List<DeckCard> deckCards = new ArrayList<>();
    @Transient
//    @JsonIgnore
    private List<Card> cards = new ArrayList<>();

    private String apiFeedSource;

    private String publisher;

    public String getApiFeedSource() {
        return apiFeedSource;
    }

    public void setApiFeedSource(String apiFeedSource) {
        this.apiFeedSource = apiFeedSource;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public long getDeckId() {
        return deckId;
    }

    public void setDeckId(long deckId) {
        this.deckId = deckId;
    }

    public void addCard(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void addDeckCard(DeckCard card) {
        if (card != null) {
            deckCards.add(card);
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public String getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Approver getApprover() {
        return approver;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public List<DeckCard> getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(List<DeckCard> deckCards) {
        this.deckCards = deckCards;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthorHandle() {
        return authorHandle;
    }

    public void setAuthorHandle(String authorHandle) {
        this.authorHandle = authorHandle;
    }
}