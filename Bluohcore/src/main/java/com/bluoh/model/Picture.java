package com.bluoh.model;

/**
 * Created by Ashutosh on 14-11-2016.
 */
public class Picture {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}
