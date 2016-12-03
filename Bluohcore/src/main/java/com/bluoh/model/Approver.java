package com.bluoh.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Ashutosh on 27-09-2016.
 */

public class Approver {

    private int liveDays;
    @NotBlank
    private String ranking;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date liveOnDate;
    private String comments;

    public int getLiveDays() {
        return liveDays;
    }

    public void setLiveDays(int liveDays) {
        this.liveDays = liveDays;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public Date getLiveOnDate() {
        return liveOnDate;
    }

    public void setLiveOnDate(Date liveOnDate) {
        this.liveOnDate = liveOnDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
