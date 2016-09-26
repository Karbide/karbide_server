package com.bluoh.service;

import com.bluoh.model.Deck;

import java.util.List;

/**
 * Created by Ashutosh on 25-09-2016.
 */
public interface DeckService {
    Deck create(Deck deck);

    Deck delete(String id);

    List<Deck> findAll();

    Deck findById(String id);
}
