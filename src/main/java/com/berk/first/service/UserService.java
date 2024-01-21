package com.berk.first.service;

import com.berk.first.model.UserCreateRequest;
import com.berk.first.model.UserListResponse;
import com.berk.first.model.UserResponse;


//User service tanımı 2 tane servis tanımlı birisi bütün user listesini dönüyor diğeri sadece 1 user dnüyor

public interface UserService {
    UserListResponse getAllUsers();

    UserResponse getUserByUserId(String userId);
    UserResponse setUserWithData(UserCreateRequest request);
}
