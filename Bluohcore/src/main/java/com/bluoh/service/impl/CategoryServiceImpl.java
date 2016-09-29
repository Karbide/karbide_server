package com.bluoh.service.impl;

import com.bluoh.model.Categories;
import com.bluoh.repository.CategoryRepository;
import com.bluoh.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository repository;

    @Autowired
    MongoTemplate template;

    @Override
    public Categories getAllCategories() {
        Categories categories = repository.findOne("57de6284a444826a11a5946b");
        return categories;
    }

    @Override
    public boolean addCategories(Categories categories) {

        Update update = new Update();
        BasicDBList list = new BasicDBList();
        for (String cat : categories.getCategory()){
            list.add(cat);
        }
        update.addToSet("category", BasicDBObjectBuilder.start("$each", list).get());
        Criteria criteria = Criteria.where("_id").is("57de6284a444826a11a5946b");
        template.updateFirst(Query.query(criteria), update, "categories_master");
        return true;
    }
}