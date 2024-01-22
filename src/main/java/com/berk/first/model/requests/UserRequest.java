package com.berk.first.model.requests;

import lombok.Data;

//sadece bir user çekmek kullanılan servis için request objesi
@Data
public class UserRequest {
    private String userId;
}
