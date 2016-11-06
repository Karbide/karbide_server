package com.bluoh.service;

import com.bluoh.model.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback create(Feedback feedback);

    List<Feedback> findAll();
}
