package com.bluoh.controller;

import com.bluoh.model.Categories;
import com.bluoh.service.CategoryService;
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

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    private final CategoryService service;

    @Autowired
    public CategoriesController(CategoryService service) {
        this.service = service;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Categories getAll(){
        LOGGER.info("Into the Category method");
        return service.getAllCategories();
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> addCategories(@RequestBody Categories categories){
        boolean t = service.addCategories(categories);
        Map<String, String> response = new HashMap<>();
        response.put("isSuccess", t+"");
        return response;
    }
}