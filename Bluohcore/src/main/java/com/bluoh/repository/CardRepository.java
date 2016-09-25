package com.bluoh.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bluoh.model.Card;

public interface CardRepository extends MongoRepository<Card, String>{

}