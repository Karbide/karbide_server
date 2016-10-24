package com.bluoh.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.bluoh.model.Card;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CardRepository extends MongoRepository<Card, String>{

    //@Query(value = "{}", fields = "{cards : { $slice : 1 }}")
    List<Card> findByStatusOrderByCurretWeightAscCreatedTimeDesc(String status);
    //yourRepository.findOneActive(new Sort(Sort.Direction.DESC, "created"))
}