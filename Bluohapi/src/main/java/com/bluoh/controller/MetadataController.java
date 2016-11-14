package com.bluoh.controller;

import com.bluoh.model.Metadata;
import com.bluoh.service.MetadataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ashutosh on 05-11-2016.
 */

@RestController
@RequestMapping("/metadata")
public class MetadataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetadataController.class);

    @Autowired
    private final MetadataService service;

    public MetadataController(MetadataService service) {
        this.service = service;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Metadata> getConfiguration(){
        return service.findAll();
    }
}