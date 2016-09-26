package com.bluoh.service.impl;

import com.bluoh.model.Tags;
import com.bluoh.service.TagsService;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 25-09-2016.
 */

@Service
public class TagsServiceImpl implements TagsService{

    @Override
    public Tags getAll() {
        return null;
    }

    @Override
    public boolean addTags(String tag[]) {
        return true;
    }
}
