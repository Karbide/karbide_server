package com.bluoh.service.impl;

import com.bluoh.model.Categories;
import com.bluoh.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 25-09-2016.
 */

@Service
public class CategoryServiceImpl implements CategoryService{

    @Override
    public Categories getAll() {
        return null;
    }

    @Override
    public boolean addCategories(String category[]) {
        return true;
    }
}