package com.berk.first.service;

import com.berk.first.model.requests.UserCreateRequest;
import com.berk.first.model.response.Response;
import com.berk.first.model.response.UserListResponse;
import com.berk.first.model.response.UserResponse;
import com.berk.first.model.requests.UserDeleteRequest;


//User service tanımı 2 tane servis tanımlı birisi bütün user listesini dönüyor diğeri sadece 1 user dnüyor

public interface UserService {
    UserListResponse getAllUsers();

    UserResponse getUserByUserId(String userId);
    UserResponse setUserWithData(UserCreateRequest request);
     Response deleteUserWithData(UserDeleteRequest request);
}
