package com.bluoh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by deepeshuniyal on 06/11/16.
 */
@Configuration
@Component
public class Config {

    @Value("${karbide.cardServeCount}")
    private int cardServeCount;

    public int getCardServeCount() {
        return cardServeCount;
    }

    public void setCardServeCount(int cardServeCount) {
        this.cardServeCount = cardServeCount;
    }

    @Override
    public String toString() {
        return "Config{" +
                "cardServeCount='" + cardServeCount + '\'' +
                '}';
    }
}
