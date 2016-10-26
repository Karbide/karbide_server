package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Deepesh Uniyal on 26-10-2016.
 */

@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImpressionWeightData {


    @Id
    private String id;

    @NotBlank(message = "User Id cannot be blank")
    private String userId;

    private String cardId;
    @LastModifiedDate
    private Date impressionDate;

    private int weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", impressionDate=" + impressionDate +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImpressionWeightData that = (ImpressionWeightData) o;

        return getCardId().equals(that.getCardId());

    }

    @Override
    public int hashCode() {
        return getCardId().hashCode();
    }
}
