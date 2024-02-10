package com.berk.first.dao.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {
    private boolean success;
    private T data;
}
