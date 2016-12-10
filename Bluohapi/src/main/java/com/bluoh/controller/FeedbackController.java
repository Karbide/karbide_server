package com.bluoh.controller;

import com.bluoh.model.Feedback;
import com.bluoh.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ashutosh on 05-11-2016.
 */

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService service;

    @Autowired
    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Feedback createFeedback(@RequestBody @Valid Feedback feedback) {
        return service.create(feedback);
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Feedback> getFeedbacks() {
        return service.findAll();
    }
}