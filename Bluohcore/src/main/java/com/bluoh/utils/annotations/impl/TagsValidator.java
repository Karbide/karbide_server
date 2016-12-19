package com.bluoh.utils.annotations.impl;

import com.bluoh.service.TagsService;
import com.bluoh.utils.annotations.ValidTags;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ashutosh on 19-12-2016.
 */
public class TagsValidator implements ConstraintValidator<ValidTags, List<String>> {

    @Autowired
    TagsService service;

    public void initialize(ValidTags constraint) {
    }

    public boolean isValid(List<String> tags, ConstraintValidatorContext context) {
        List<String> validTags = Arrays.asList(service.getAllTags().getTag());
        return validTags.containsAll(tags);
    }
}
