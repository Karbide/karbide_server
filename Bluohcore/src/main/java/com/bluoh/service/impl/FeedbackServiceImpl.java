package com.bluoh.service.impl;

import com.bluoh.model.Feedback;
import com.bluoh.repository.FeedbackRepository;
import com.bluoh.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ashutosh on 05-11-2016.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Autowired
    private MongoOperations operations;

    @Override
    public List<Feedback> findAll() {
        Feedback feedback = new Feedback();
        List<Feedback> list = operations.find(Query.query(Criteria.where("userId").in(feedback.getUserId())),Feedback.class);
        return list;
    }

    @Override
    public Feedback create(Feedback feedback) {
        return repository.save(feedback);
    }
}
