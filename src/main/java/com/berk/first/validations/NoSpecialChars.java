package com.berk.first.validations;

import com.berk.first.validations.Impl.NoSpecialCharsValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoSpecialCharsValidatorImpl.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@NotBlank
@ReportAsSingleViolation
public @interface NoSpecialChars {
    String message() default "Invalid characters found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
