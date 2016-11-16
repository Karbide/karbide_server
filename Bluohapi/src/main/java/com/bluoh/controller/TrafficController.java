package com.bluoh.controller;

import com.bluoh.model.Traffic;
import com.bluoh.service.TrafficService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Ashutosh on 05-11-2016.
 */

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficController.class);

    @Autowired
    private final TrafficService service;

    public TrafficController(TrafficService service) {
        this.service = service;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Trigger for different type of event in app", notes = "for Flipped and Seen need to send (activity='Flip' and activity='Seen') and (type='VisitData') for Likes and dislikes (activity='likes' and activity='dislikes')")
    public Traffic createFeedback(@RequestBody @Valid Traffic traffic) {
        Traffic created = service.create(traffic);
        return created;
    }
}