package com.berk.first.controller;

import com.berk.first.model.*;
import com.berk.first.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.berk.first.helper.UserHelper.logError;
import static com.berk.first.helper.UserHelper.logInfo;

@RestController
@RequiredArgsConstructor
public class UserControllers {

    final UserService userService;

    @GetMapping("hello")
    public void hello() {
        System.out.println("Hello World");
    }


    //user listesi dönen get method
    @GetMapping("/users")
    public ResponseEntity<UserListResponse> getAllUsers() {

        final UserListResponse userListResponse = userService.getAllUsers();

        return ResponseEntity.ok(userListResponse);
    }


    @PostMapping("/user-add")
    public ResponseEntity<Object> setUserWithData(@Validated @RequestBody UserCreateRequest request, BindingResult result) {

        if (result.hasErrors()) {
            // Validation errors occurred
            logInfo(String.format("bad req: %s --- problem: %s",request.toString(),result));
            return ResponseEntity.badRequest().body(createErrorResponse(result));
        }
        try {
            final UserResponse userResponse = userService.setUserWithData(request);
            return ResponseEntity.ok(userResponse.getUser());
        } catch (Exception e) {
            logError("An error occurred during user creation:", e);
            // Return a 500 Internal Server Error response
            return ResponseEntity.status(500).build();
        }
    }

    //1 adet user dönen post method
    @PostMapping("/user")
    public ResponseEntity<UserResponse> getUser(@RequestBody final UserRequest userRequest) {

        final UserResponse userResponse = userService.getUserByUserId(userRequest.getUserId());

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponse> getUserPathParam(@PathVariable("userId") final String userId) {

        final UserResponse userResponse = userService.getUserByUserId(userId);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUserQueryParam(@RequestParam("userId") final String userId) {

        final UserResponse userResponse = userService.getUserByUserId(userId);

        return ResponseEntity.ok(userResponse);
    }

    private ErrorResponse createErrorResponse(BindingResult result) {
        ErrorResponse errorResponse = new ErrorResponse();
        result.getFieldErrors().forEach(error -> {
            errorResponse.getErrorList().add(error.getField() + ": " + error.getDefaultMessage());
        });
        return errorResponse;
    }
}
