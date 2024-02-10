package com.berk.first.dao.response;

import com.berk.first.model.User;
import lombok.Data;

import java.util.List;


//sadece 1 user dönen servis response'u
@Data
public class UserResponse {
    private User user;
}
