package com.bluoh.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Ashutosh on 02-10-2016.
 */
@SuppressWarnings("WeakerAccess")
public class DateTimeField {

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @CreatedDate
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date time;

    public DateTimeField(Date date, Date time) {
        this.date = date;
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}