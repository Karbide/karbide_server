package com.bluoh.repository;

import com.bluoh.model.ImpressionWeightData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ImpressionWeightDataRepository extends MongoRepository<ImpressionWeightData, String>{

    List<ImpressionWeightData> findByUserIdAndCardId(String userId, String cardId);
}