package com.bluoh.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bluoh.model.Card;

import java.util.List;

public interface CardRepository extends MongoRepository<Card, String>{

    List<Card> findByIdIn(List<String> stringList);
}