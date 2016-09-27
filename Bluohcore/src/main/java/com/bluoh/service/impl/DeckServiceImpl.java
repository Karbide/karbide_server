package com.bluoh.service.impl;

import com.bluoh.model.Card;
import com.bluoh.model.Deck;
import com.bluoh.service.CardService;
import com.bluoh.service.DeckService;
import com.bluoh.service.SequenceService;
import com.bluoh.utils.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ashutosh on 25-09-2016.
 */
@Service
final class DeckServiceImpl implements DeckService {


    @Autowired
    private CardService cardService;

    @Autowired
    private SequenceService sequenceService;


    @Override
    public Deck create(Deck deck) throws SequenceException{
        Deck deck1 = new Deck();
        long sequenceId = sequenceService.getNextSequenceId("deckId");
        deck1.setDeckId(sequenceId);
        for(Card card : deck.getCards()){
            card.setDeckId(sequenceId);
            deck1.addCard(cardService.create(card));
        }
        return deck1;
    }

    @Override
    public Deck delete(String id) {

        Deck response = new Deck();
        Query query = new Query();
        query.addCriteria(Criteria.where("deckId").in(id));
        List<Card> cards = cardService.find(query);
        return response;
    }

    @Override
    public List<Deck> findAll() {
        return null;
    }

    @Override
    public Deck findById(long id) {
        Deck response = new Deck();
        Query query = new Query();
        query.addCriteria(Criteria.where("deckId").in(id));
        List<Card> cards = cardService.find(query);
        response.setCards(cards);
        response.setDeckId(id);
        return response;
    }
}
