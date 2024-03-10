package com.jesus.springappcrud.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {ExistsByUsernameValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByUsername {

    String message() default "ya existe en la base de datos escoja otro nombre";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
