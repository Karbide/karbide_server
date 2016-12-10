package com.bluoh.model;

public class NotificationData {

    private String image;
    private String AnotherActivity;
    private String title;
    private String message;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAnotherActivity() {
        return AnotherActivity;
    }

    public void setAnotherActivity(@SuppressWarnings("SameParameterValue") String anotherActivity) {
        AnotherActivity = anotherActivity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
