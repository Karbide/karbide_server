package com.bluoh.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh on 25-09-2016.
 */
public final class Deck {

    private List<Card> cards = new ArrayList<Card>();

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        if(card != null){
            cards.add(card);
        }
    }
}
