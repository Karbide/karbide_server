package com.bluoh.repository;

import com.bluoh.model.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImpressionWeightDataRepository extends MongoRepository<Categories, String>{

}