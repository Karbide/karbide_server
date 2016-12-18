package com.bluoh.service;

import com.bluoh.model.Deck;
import com.bluoh.model.DeckActivity;
import org.springframework.data.domain.Page;

/**
 * Created by Ashutosh on 25-09-2016.
 */
public interface DeckService {
    Deck create(Deck deck);

    Deck delete(String id);

    Page<Deck> findAll(int page);

    Page<Deck> findAll(int page, String category, String tags);

    Page<Deck> findAll(Long[] deckId, int page);

    Deck findById(long id);

    boolean updateDeckActivity(DeckActivity deckActivity);

}
