package com.bluoh.state;

/**
 * Created by Ashutosh on 07-10-2016.
 */
@SuppressWarnings("ALL")
public interface State {

    void doAction(StateContextInterface contextInterface);
}
