package com.bluoh.service;

import java.util.List;

import com.bluoh.model.Card;

public interface CardService {

    Card create(Card card);

    Card delete(String id);

    List<Card> findAll();

    Card findById(String id);

    Card update(Card card);

}
