package com.bluoh.service;

import com.bluoh.utils.SequenceException;

/**
 * Created by Ashutosh on 26-09-2016.
 */
public interface SequenceService {

    @SuppressWarnings("SameParameterValue")
    long getNextSequenceId(String key) throws SequenceException;
}
