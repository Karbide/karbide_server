package com.bluoh.service.impl;

import com.bluoh.model.Notification;
import com.bluoh.model.NotificationData;
import com.bluoh.service.NotificationService;
import com.bluoh.utils.Util;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ashutosh on 17-11-2016.
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public String send(String message, String title, String image, String gcm_key) {

        Notification notification = new Notification();
        notification.setTo(gcm_key);
        NotificationData  notificationData = new NotificationData();
        notificationData.setAnotherActivity("true");
        notificationData.setImage(image);
        notificationData.setMessage(message);
        notificationData.setTitle(title);
        notification.setData(notificationData);
        return Util.sendNotification(notification);
    }

    @Override
    public String sendToTopics(String message, String title, String image, String topic) {

        return send(message,title,image,"/topics/"+topic);
    }

    @Override
    public String sendMultiple(String message, String title, String image, List<String> gcm_keys) {
        String response = "failed at first attempt";
        for (String gcm_key : gcm_keys){
            response = send(message,title,image,gcm_key);
            if(response.contains("unsuccessful")){
                break;
            }
        }
        return response;
    }
}
