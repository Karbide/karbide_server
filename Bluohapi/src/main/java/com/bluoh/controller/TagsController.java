package com.bluoh.controller;

import com.bluoh.model.Tags;
import com.bluoh.service.TagsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ashutosh on 25-09-2016.
 */

@CrossOrigin()
@RestController
@RequestMapping("/tags")
public class TagsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    private final TagsService service;

    @Autowired
    public TagsController(TagsService service) {
        this.service = service;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public Tags getAll(){
        LOGGER.info("Into the Tags method");
        return service.getAllTags();
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> addCategories(@RequestBody Tags tags){
        boolean t = service.addTags(tags);
        Map<String, String> response = new HashMap<String,String>();
        response.put("isSuccess", t+"");
        return response;
    }
}