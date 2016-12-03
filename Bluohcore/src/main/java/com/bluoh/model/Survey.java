package com.bluoh.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Ashutosh on 25-09-2016.
 */
@Document
public class Survey {

    private String options[];

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
