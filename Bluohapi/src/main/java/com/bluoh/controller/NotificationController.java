package com.bluoh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ashutosh on 17-11-2016.
 */

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String sendNotification(@RequestParam String message, @RequestParam String gcm_key){

        return "Ok";
    }
}