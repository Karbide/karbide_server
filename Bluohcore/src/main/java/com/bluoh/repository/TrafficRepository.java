package com.bluoh.repository;

import com.bluoh.model.Traffic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrafficRepository extends MongoRepository<Traffic, String>{

}