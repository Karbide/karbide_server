package com.bluoh.repository;

import com.bluoh.model.Metadata;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetadataRepository extends MongoRepository<Metadata, String>{

}