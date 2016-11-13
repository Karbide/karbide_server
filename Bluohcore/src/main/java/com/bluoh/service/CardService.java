package com.bluoh.service;

import com.bluoh.model.Card;
import com.bluoh.model.CardServe;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface CardService {

    Card create(Card card);

    Card delete(String id);

    List<Card> findAll();

    List<Card> find(Query query);

    Card findById(String id);

    Card update(Card card);

    CardServe getUserCard(CardServe cardServe);
}
