package com.bluoh.repository;

import com.bluoh.model.Bookmarks;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookmarksRepository extends MongoRepository<Bookmarks, String>{

}