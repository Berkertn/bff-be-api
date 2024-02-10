package com.berk.first.dao.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {
    private List<String> errorList = new ArrayList<>();
}
