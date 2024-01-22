package com.berk.first.validations.Impl;


import com.berk.first.validations.NoSpecialChars;
import com.berk.first.validations.UUIDValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UUIDValidatorImpl implements ConstraintValidator<UUIDValidator, String> {

    @Override
    public void initialize(UUIDValidator constraintAnnotation) {
        // Initialization logic, if needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false; // Null or blank strings are not allowed
        }

        // Your custom character exclusion logic (e.g., excluding non-English characters)
        return value.matches("[a-zA-Z0-9-]+");
    }
}
