package com.berk.first.model.requests;


import com.berk.first.validations.NoSpecialChars;
import lombok.Data;

@Data
public class UserCreateRequest {
    @NoSpecialChars
    private String name;
    @NoSpecialChars
    private String surname;
    private String email;
}
