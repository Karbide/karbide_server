package com.bluoh.service.impl;

import com.bluoh.model.DeckActivity;
import com.bluoh.repository.DeckActivityRepository;
import com.bluoh.service.DeckActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 05-11-2016.
 */
@Service
public class DeckActivityServiceImpl implements DeckActivityService {


    @Autowired
    DeckActivityRepository repository;

    @Override
    public DeckActivity create(DeckActivity deckActivity) {
        DeckActivity deckActivity1 = repository.save(deckActivity);
        return  deckActivity1;
    }

    @Override
    public DeckActivity delete(String id) {
        repository.delete(id);
        return null;
    }

    @Override
    public Page<DeckActivity> findAll(int page) {
        return null;
    }

    @Override
    public DeckActivity findById(long id) {
        return null;
    }
}
