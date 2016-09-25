package com.bluoh.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluoh.model.Tags;

public interface TagsRepository extends MongoRepository<Tags, String>{

}