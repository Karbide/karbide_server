package com.bluoh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CardIdList {

    @Id
    private String id;

    private List<CardIdBean> cardIdBeen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CardIdBean> getCardIdBeen() {
        return cardIdBeen;
    }

    public void setCardIdBeen(List<CardIdBean> cardIdBeen) {
        this.cardIdBeen = cardIdBeen;
    }

    @Override
    public String toString() {
        return "CardIdList{" +
                "id='" + id + '\'' +
                ", cardIdBeen=" + cardIdBeen +
                '}';
    }
}