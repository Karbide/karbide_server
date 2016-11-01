package com.bluoh.repository;

import com.bluoh.model.Template;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Ashutosh on 11-10-2016.
 */
public interface TemplateRepository extends MongoRepository<Template, String> {

}
