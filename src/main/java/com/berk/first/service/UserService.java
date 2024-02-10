package com.berk.first.service;

import com.berk.first.dao.requests.UserCreateRequest;
import com.berk.first.dao.response.Response;
import com.berk.first.dao.response.UserListResponse;
import com.berk.first.dao.response.UserResponse;
import com.berk.first.dao.requests.UserDeleteRequest;
import org.springframework.security.core.userdetails.UserDetailsService;


//User service tanımı 2 tane servis tanımlı birisi bütün user listesini dönüyor diğeri sadece 1 user dnüyor

public interface UserService {
    UserListResponse getAllUsers();

    UserResponse getUserByUserId(String userId);

    UserResponse setUserWithData(UserCreateRequest request);

     Response deleteUserWithData(UserDeleteRequest request);

    UserDetailsService userDetailsService();
}
