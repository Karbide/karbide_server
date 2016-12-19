package com.bluoh.utils.annotations;

import com.bluoh.utils.annotations.impl.CategoriesValidator;

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
@Constraint(validatedBy = CategoriesValidator.class)
public @interface ValidCategory {

    String message() default "Invalid value in the list";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}