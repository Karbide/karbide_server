package com.bluoh.service;

import com.bluoh.model.Categories;

/**
 * Created by Ashutosh on 25-09-2016.
 */
public interface CategoryService {


    Categories getAllCategories();

    boolean addCategories(Categories category);

}
