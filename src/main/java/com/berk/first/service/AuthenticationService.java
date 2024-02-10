package com.berk.first.service;

import com.berk.first.dao.requests.SignUpRequest;
import com.berk.first.dao.requests.SigninRequest;
import com.berk.first.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
