package com.berk.first.model.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {
    private List<String> errorList = new ArrayList<>();
}
