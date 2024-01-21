package com.berk.first.controller;

import com.berk.first.model.UserRequest;
import com.berk.first.model.UserListResponse;
import com.berk.first.model.UserResponse;
import com.berk.first.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HelloController {

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



}
