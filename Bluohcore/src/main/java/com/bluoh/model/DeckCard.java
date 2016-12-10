package com.bluoh.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Ashutosh on 13-10-2016.
 */
public class DeckCard {

    @Id
    private String id;
    private int rank;
    private boolean isEnable;

    public DeckCard(String id, int rank) {
        this.id = id;
        this.rank = rank;
        this.isEnable = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
