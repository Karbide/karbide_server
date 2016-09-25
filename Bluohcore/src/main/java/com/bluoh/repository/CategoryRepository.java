package com.bluoh.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluoh.model.Categories;

public interface CategoryRepository extends MongoRepository<Categories, String>{

}