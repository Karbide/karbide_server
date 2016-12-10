package com.bluoh.controller;

import com.bluoh.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Ashutosh on 17-11-2016.
 */

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService service;

    @Autowired
    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @RequestMapping(value = "/single", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String sendNotification(@NotNull @RequestParam String message, @NotNull @RequestParam String gcm_key, @RequestParam(required = false) String image, @NotNull @RequestParam String title) {
        return service.send(message, title, image, gcm_key);
    }

    @RequestMapping(value = "/topic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String sendNotificationTopic(@NotNull @RequestParam String message, @NotNull @RequestParam String topic, @RequestParam(required = false) String image, @NotNull @RequestParam String title) {
        return service.sendToTopics(message,title,image,topic);
    }

    @RequestMapping(value = "/multiple", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String sendNotificationMultiple(@NotNull @RequestParam String message, @NotNull @RequestParam List<String> gcm_key, @RequestParam(required = false)  String image, @NotNull @RequestParam String title) {
        return service.sendMultiple(message,title,image,gcm_key);
    }
}