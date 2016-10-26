package com.bluoh.repository;

import com.bluoh.model.CardServeData;
import com.bluoh.model.ImpressionWeightData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardServeDataRepository extends MongoRepository<CardServeData, String>{

}