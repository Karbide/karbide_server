package com.bluoh.repository;

import com.bluoh.model.DeckActivity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeckActivityRepository extends MongoRepository<DeckActivity, String>{

}