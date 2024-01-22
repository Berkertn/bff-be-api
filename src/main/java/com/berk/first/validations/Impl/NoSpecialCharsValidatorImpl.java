package com.berk.first.validations.Impl;


import com.berk.first.validations.NoSpecialChars;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoSpecialCharsValidatorImpl implements ConstraintValidator<NoSpecialChars, String> {

    @Override
    public void initialize(NoSpecialChars constraintAnnotation) {
        // Initialization logic, if needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false; // Null or blank strings are not allowed
        }

        // Your custom length check (e.g., length should be between 3 and 10 characters)
        if (value.length() < 3 || value.length() > 10) {
            return false;
        }

        // Your custom character exclusion logic (e.g., excluding non-English characters)
        if (!value.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        return true; // Validation passed
    }
}
