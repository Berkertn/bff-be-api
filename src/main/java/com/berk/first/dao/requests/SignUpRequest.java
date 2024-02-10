package com.berk.first.dao.requests;

import com.berk.first.validations.NoSpecialChars;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @NoSpecialChars
    private String firstName;
    @NoSpecialChars
    private String lastName;
    private String email;
    private String password;
}