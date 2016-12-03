package com.bluoh.service;

import java.util.List;

public interface NotificationService {

    String send(String message, String title, String image, String gcm_key);

    String sendToTopics(String message, String title, String image, String topic);

    String sendMultiple(String message, String title, String image, List<String> gcm_keys);
}
