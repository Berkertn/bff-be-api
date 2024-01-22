package com.berk.first.model.requests;

import com.berk.first.validations.NoSpecialChars;
import com.berk.first.validations.UUIDValidator;
import lombok.Data;

@Data
public class UserDeleteRequest {
    @UUIDValidator
    private String userId;
}
