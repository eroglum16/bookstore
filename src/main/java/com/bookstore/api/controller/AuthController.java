package com.bookstore.api.controller;

import com.bookstore.api.model.dto.UserDTO;
import com.bookstore.api.service.UserService;
import com.bookstore.api.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final UserService userService;
    public AuthController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        userService.register(userDTO);
        return ResponseEntity.status(201).body("User registered succesfully!");
    }
}
