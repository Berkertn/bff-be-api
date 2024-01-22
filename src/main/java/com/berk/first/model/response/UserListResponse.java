package com.berk.first.model.response;

import com.berk.first.model.User;
import lombok.Data;

import java.util.List;


//user listesi dönen servis response'u
@Data
public class UserListResponse {
    private List<User> users;
}
