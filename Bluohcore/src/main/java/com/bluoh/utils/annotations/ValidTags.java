package com.bluoh.utils.annotations;

import com.bluoh.utils.annotations.impl.TagsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ashutosh on 19-12-2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = TagsValidator.class)
public @interface ValidTags {

    String message() default "Invalid value in the Tags list";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}