package com.bluoh.repository;

import com.bluoh.model.Deck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DeckRepository extends MongoRepository<Deck, String>{

    @Query(value = "{}", fields = "{cards : { $slice : 1 }}")
    Page<Deck> findAll(Pageable pageable);

    @Query(value = "{ '_id' : { $in: ?0 } }", fields = "{cards : { $slice : 1 }}")
    Page<Deck> findAll(Long[] deckId, Pageable pageable);
}