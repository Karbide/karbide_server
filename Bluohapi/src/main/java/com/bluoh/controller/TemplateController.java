package com.bluoh.controller;

import com.bluoh.model.Template;
import com.bluoh.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ashutosh on 25-09-2016.
 */

@CrossOrigin()
@RestController
@RequestMapping("/template")
public class TemplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    private final TemplateService service;

    @Autowired
    public TemplateController(TemplateService service) {
        this.service = service;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAll() {
        LOGGER.info("Into the template method");
        List<Template> templates= service.getAll();

        Map<String,Object> response = new HashMap<String, Object>();
        response.put("content", templates);
        return response;
    }

}