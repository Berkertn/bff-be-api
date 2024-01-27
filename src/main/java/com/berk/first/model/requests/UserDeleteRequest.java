package com.berk.first.model.requests;

import com.berk.first.validations.NoSpecialChars;
import com.berk.first.validations.UUIDValidator;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDeleteRequest {
    @UUIDValidator
    private UUID userId;
}
