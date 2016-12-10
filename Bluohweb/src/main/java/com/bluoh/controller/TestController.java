package com.bluoh.controller;

import com.bluoh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by deepeshuniyal on 19/09/16.
 */
@RestController
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/testing")
    public ResponseEntity<?> testController(){
        String t = testService.testing();
        //noinspection unchecked
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}
