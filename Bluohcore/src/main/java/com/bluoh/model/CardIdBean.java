package com.bluoh.model;

import java.util.Date;

public final class CardIdBean {

    private String id;

    private Date modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "CardIdBean{" +
                "id='" + id + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}