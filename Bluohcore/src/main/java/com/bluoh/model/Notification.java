package com.bluoh.model;

/**
 * Created by Ashutosh on 03-12-2016.
 */
public class Notification {

    private String to;
    private NotificationData data;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public NotificationData getData() {
        return data;
    }

    public void setData(NotificationData data) {
        this.data = data;
    }
}

