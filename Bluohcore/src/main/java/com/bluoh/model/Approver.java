package com.bluoh.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Ashutosh on 27-09-2016.
 */
public class Approver {

    private int liveDays;
    @NotBlank
    private String ranking;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
