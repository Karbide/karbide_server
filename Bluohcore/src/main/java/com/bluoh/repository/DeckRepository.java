package com.bluoh.repository;

import com.bluoh.model.Deck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DeckRepository extends MongoRepository<Deck, String> {

    @Query(value = "{ 'categories' : { $in : [ ?0 ] }, 'tags' : { $in : ?1 } }", fields = "{cards : { $slice : 1 " +
            "}}")
    Page<Deck> findAllByCategoryAndTags(String category, String[] tags, Pageable pageable);

    @Query(value = "{ 'categories' : { $in : [ ?0 ] } }", fields = "{cards : { $slice : 1 }}")
    Page<Deck> findAllByCategory(String category, Pageable pageable);

    @Query(value = "{ 'tags' : { $in : ?0 } }", fields = "{cards : { $slice : 1 }}")
    Page<Deck> findAllByTags(String[] tags, Pageable pageable);

    @Query(value = "{}", fields = "{cards : { $slice : 1 }}")
    Page<Deck> findAll(Pageable pageable);

    @Query(value = "{ '_id' : { $in: ?0 } }", fields = "{cards : { $slice : 1 }}")
    Page<Deck> findAll(Long[] deckId, Pageable pageable);
}