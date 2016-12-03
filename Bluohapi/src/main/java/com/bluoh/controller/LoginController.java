package com.bluoh.controller;

import com.bluoh.model.FbLogin;
import com.bluoh.model.User;
import com.bluoh.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Ashutosh on 05-11-2016.
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create User Login", notes = "Sample request : {\n" +
            "  \"name\": \"Basant Kumar Thakur\",\n" +
            "  \"gender\": \"male\",\n" +
            "  \"email\": \"basant1988@gmail.com\",\n" +
            "  \"picture\": {\n" +
            "    \"data\": {\n" +
            "      \"height\": 480,\n" +
            "      \"is_silhouette\": false,\n" +
            "      \"url\": \"https://scontent.xx.fbcdn.net/v/t1.0-1/p480x480/14925367_10209195869366348_57355515163401360_n.jpg?oh=ed7fd29c83d24e4d845573a66d5da59c&oe=58946571\",\n" +
            "      \"width\": 480\n" +
            "    }\n" +
            "  },\n" +
            "  \"id\": \"10209325852575847\",\n" +
            "  \"utm_content\": \"string\",\n" +
            "  \"utm_medium\": \"string\",\n" +
            "  \"utm_source\": \"string\",\n" +
            "  \"utm_term\": \"string\",\n" +
            "  \"utm_campaign\": \"string\"\n" +
            "}")
    public User createFeedback(@RequestBody @Valid FbLogin login) {
        User created = service.create(login);
        return created;
    }

//    @Secured({"ROLE_USER"})
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<Feedback> getFeedbacks() {
//        List<Feedback> created = service.findAll();
//        return created;
//    }
}