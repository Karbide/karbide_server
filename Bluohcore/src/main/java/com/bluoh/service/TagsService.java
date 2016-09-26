package com.bluoh.service;

import com.bluoh.model.Tags;

/**
 * Created by Ashutosh on 25-09-2016.
 */
public interface TagsService {

    Tags getAll();

    boolean addTags(String tag[]);

}
