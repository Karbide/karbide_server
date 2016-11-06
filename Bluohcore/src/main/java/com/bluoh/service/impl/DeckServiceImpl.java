package com.bluoh.service.impl;

import com.bluoh.model.Card;
import com.bluoh.model.Deck;
import com.bluoh.model.DeckActivity;
import com.bluoh.model.DeckCard;
import com.bluoh.repository.DeckRepository;
import com.bluoh.service.CardService;
import com.bluoh.service.DeckActivityService;
import com.bluoh.service.DeckService;
import com.bluoh.service.SequenceService;
import com.bluoh.utils.CardNotFoundException;
import com.bluoh.utils.SequenceException;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
    DeckActivityService deckActivityService;

    @Autowired
    private DeckRepository repository;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    Environment env;

    @Override
    public Deck create(Deck deck) throws SequenceException {
        Deck deck1 = new Deck();
        long sequenceId = sequenceService.getNextSequenceId("deckId");
        deck.setDeckId(sequenceId);
        int rank = 1;
        for (Card card : deck.getCards()) {
            card.setDeckId(sequenceId);
            card.setAuthor(deck.getAuthor());
            card.setUserId(deck.getUserId());
            deck.addDeckCard(new DeckCard(cardService.create(card).getId(), rank, true));
            rank++;
        }
        try {
            deck1 = repository.save(deck);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deck1;
    }


    @Override
    public Deck delete(String id) {
        Deck response = new Deck();
        List<Card> cards = cardService.find(Query.query(Criteria.where("deckId").in(id)));
        return response;
    }

    @Override
    public Page<Deck> findAll(int page) {
        int pagingLength = Integer.parseInt(env.getProperty("paging"));
        Pageable pageable = new PageRequest(page, pagingLength);
        Page<Deck> decks = repository.findAll(pageable);
        for (Deck deck : decks) {
            try {
                deck.addCard(cardService.findById(deck.getDeckCards().get(0).getId()));
            } catch (Exception e) {
                throw new CardNotFoundException("Unable to find card for deckId" + deck.getDeckId());
            }
        }
        return decks;
    }

    @Override
    public Deck findById(long id) {
        Deck response = new Deck();
        response = mongoOperations.findOne(Query.query(Criteria.where("_id").in(id)), Deck.class);
        List<Card> cards = cardService.find(Query.query(Criteria.where("deckId").in(id)));
        response.setCards(cards);
//        response.setDeckId(id);
        return response;
    }

    @Override
    public boolean updateDeckActivity(DeckActivity deckActivity) {
        Query query = new Query();
        try {
            query.addCriteria(Criteria.where("_id").in(deckActivity.getDeckId()));
            Update update = new Update();
            String[] params = {"likes","dislikes","views"};
            for( String param : params){
                if(deckActivity.getActivity().equals(param)){
                    if(param.equals("dislikes")){
                        update.inc("likes",-1);
                    }else {
                        update.inc(param,1);
                    }
                    break;
                }
            }
            WriteResult writeResult = mongoOperations.updateFirst(query, update, Deck.class);
            System.out.println(writeResult.toString());
            if (writeResult.getN() == 0) {
                return false;
            }
            deckActivityService.create(deckActivity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}