package com.jesus.springappcrud.validation;

import com.jesus.springappcrud.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsByUsernameValidator implements ConstraintValidator<ExistsByUsername,String> {

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (service == null) {
            return true;
        }

        return !service.existsByUsername(value);
    }
}
