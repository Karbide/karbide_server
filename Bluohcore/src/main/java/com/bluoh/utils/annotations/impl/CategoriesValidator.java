package com.bluoh.utils.annotations.impl;

import com.bluoh.service.CategoryService;
import com.bluoh.utils.annotations.ValidCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ashutosh on 19-12-2016.
 */
public class CategoriesValidator implements ConstraintValidator<ValidCategory, List<String>> {

    @Autowired
    private CategoryService service;

    @Override
    public void initialize(ValidCategory validCategory) {
    }

    @Override
    public boolean isValid(List<String> categories, ConstraintValidatorContext constraintValidatorContext) {

        List<String> validCategories = Arrays.asList(service.getAllCategories().getCategory());
        return validCategories.containsAll(categories);
    }
}