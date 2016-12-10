package com.bluoh.state;

import com.bluoh.state.impl.*;

/**
 * Created by Ashutosh on 07-10-2016.
 */
public enum States {

    Completed(new Completed(), "Completed"),
    Draft(new Draft(), "Draft"),
    InReview(new InReview(), "InReview"),
    Published(new Published(), "Published"),
    Queued(new Queued(), "Queued");

    private final State state;
    private final String value;

    States(State state , String value){
        this.state = state;
        this.value = value;
    }

    public State getState(){
        return this.state;
    }

    public String getValue(){
        return this.value;
    }
}
