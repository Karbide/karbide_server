package com.bluoh.controller;

import com.bluoh.model.Feed;
import com.bluoh.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ashutosh on 22-12-2016.
 */
@RestController
@RequestMapping("/feed")
public class FeedController {

    private final FeedService service;

    @Autowired
    public FeedController(FeedService service) {
        this.service = service;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Feed createFeed(@RequestBody @Valid Feed feed) {
        return service.addFeed(feed);
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Feed> getAllFeed() {
        return service.getAllFeeds();
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Feed deleteFeed(@RequestParam String feedId) {
        return service.deleteFeed(feedId);
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.PUT, value = "/{feedId}")
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, Object> updateFeed(@PathVariable("feedId") String feedId, @RequestBody @Valid Feed feed) {
        HashMap<String, Object> response = new HashMap<>();
        feed.setId(feedId);
        Feed responsefeed = service.updateFeed(feed);
        if (responsefeed != null) {
            response.put("message", "Things went out well");
        } else {
            response.put("message", "We need to do more than this");
        }
        return response;
    }
}