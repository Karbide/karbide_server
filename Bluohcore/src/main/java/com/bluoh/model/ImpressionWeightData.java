package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Ashutosh on 11-10-2016.
 */

@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ImpressionWeightData {

    @Id
    private String userId;

    @JsonIgnore
    private String cardId;

    @LastModifiedDate
    @JsonIgnore
    private Date impressionDate;

    @JsonIgnore
    private int weight;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getCardId() {

        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Date getImpressionDate() {
        return impressionDate;
    }

    public void setImpressionDate(Date impressionDate) {
        this.impressionDate = impressionDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ImpressionWeightData{" +
                "userId='" + userId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", impressionDate=" + impressionDate +
                ", weight=" + weight +
                '}';
    }
}
