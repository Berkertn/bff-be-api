package com.berk.first.model;

import lombok.Data;

import java.util.List;


//sadece 1 user dönen servis response'u
@Data
public class UserResponse {
    private User user;
}
