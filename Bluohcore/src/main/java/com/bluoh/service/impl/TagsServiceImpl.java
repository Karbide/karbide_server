package com.bluoh.service.impl;

import com.bluoh.model.Tags;
import com.bluoh.repository.TagsRepository;
import com.bluoh.service.TagsService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObjectBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 25-09-2016.
 */

@Service
public class TagsServiceImpl implements TagsService{

    @Autowired
    MongoTemplate template;

    @Autowired
    TagsRepository repository;

    @Override
    public Tags getAllTags() {
        Tags tags = repository.findOne("57de6bdba444826a11a5946c");
        return tags;
    }

    @Override
    public boolean addTags(Tags tags) {
        Update update = new Update();
        BasicDBList list = new BasicDBList();
        for (String cat : tags.getTag()){
            list.add(cat);
        }
        update.addToSet("tag", BasicDBObjectBuilder.start("$each", list).get());
        Criteria criteria = Criteria.where("_id").is("57de6bdba444826a11a5946c");
        template.updateFirst(Query.query(criteria), update, "tags_master");
        return true;
    }
}
