package com.bluoh.state;

/**
 * Created by Ashutosh on 07-10-2016.
 */
public interface StateContextInterface {

    State getNextState(States state, Event action);

}
