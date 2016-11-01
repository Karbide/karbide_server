package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh on 25-09-2016.
 */
@Document
public final class Deck {

    private static SecUserDetails userDetails = (SecUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    @Id
    private long deckId;
    @JsonIgnore
    private String userId = userDetails.getId();
    private String type;
//    @NotBlank(message = "Title can not be empty.")
//    private String title;
    @NotBlank(message = "Author can not be empty.")
    private String author;
    @NotBlank(message = "Display Name can not be empty.")
    private String displayName;
    @NotNull(message = "Category can not be empty.")
    private List<String> categories;
    @NotNull(message = "Tags can not be empty.")
    private List<String> tags;
    private Approver approver;
    private String status;
    private int likes;
    private int dislikes;
    @JsonIgnore
    @Field(value = "cards")
//    @JsonProperty("cards")
    private List<DeckCard> deckCards = new ArrayList<DeckCard>();
    @Transient
//    @JsonIgnore
    private List<Card> cards = new ArrayList<Card>();


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

    public void addCard(Card card){
        if(card != null){
            cards.add(card);
        }
    }

    public void addDeckCard(DeckCard card){
        if(card != null){
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

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDisplayName() {
        return displayName;
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

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
}
