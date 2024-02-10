package com.berk.first.dao.requests;

import com.berk.first.validations.NoSpecialChars;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailRequest {
    private String email;
    private String password;
}
