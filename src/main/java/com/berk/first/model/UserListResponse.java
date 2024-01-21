package com.berk.first.model;

import lombok.Data;

import java.util.List;


//user listesi dönen servis response'u
@Data
public class UserListResponse {
    private List<User> users;
}
