package com.bluoh.repository;

import com.bluoh.model.CardIdList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardIdListRepository extends MongoRepository<CardIdList, String>{

}