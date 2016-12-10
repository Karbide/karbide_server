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

    private final FeedbackRepository repository;

    private final MongoOperations operations;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository repository, MongoOperations operations) {
        this.repository = repository;
        this.operations = operations;
    }

    @Override
    public List<Feedback> findAll() {
        Feedback feedback = new Feedback();
        return operations.find(Query.query(Criteria.where("userId").in(feedback.getUserId())), Feedback.class);
    }

    @Override
    public Feedback create(Feedback feedback) {
        return repository.save(feedback);
    }
}
