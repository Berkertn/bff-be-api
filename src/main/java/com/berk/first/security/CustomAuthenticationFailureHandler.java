package com.berk.first.security;

import com.berk.first.dao.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setContentType("application/json");
        ErrorResponse errorResponse = new ErrorResponse();

        if (exception instanceof UsernameNotFoundException) {
            errorResponse.getErrorList().add("Authentication failed: User not found.");
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            errorResponse.getErrorList().add("Authentication failed: Unexpected error occurred.");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        String jsonResponse = objectMapper.writeValueAsString(errorResponse);
        PrintWriter writer = response.getWriter();
        writer.println(jsonResponse);
        writer.flush();
    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, ExpiredJwtException exception) throws IOException {
        ErrorResponse errorResponse = new ErrorResponse();

        if (exception instanceof ExpiredJwtException) {
            errorResponse.getErrorList().add("Authentication failed: Expired token. Please log in again.");
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            errorResponse.getErrorList().add("Authentication failed: Unexpected error occurred.");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        String jsonResponse = objectMapper.writeValueAsString(errorResponse);
        PrintWriter writer = response.getWriter();
        writer.println(jsonResponse);
        writer.flush();
    }
}
