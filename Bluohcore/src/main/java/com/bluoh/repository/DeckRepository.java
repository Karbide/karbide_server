package com.bluoh.repository;

import com.bluoh.model.Deck;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeckRepository extends MongoRepository<Deck, String>{

}