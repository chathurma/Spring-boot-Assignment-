package com.isej.ISEJ.api.controller;

import com.isej.ISEJ.api.request.UserRequest;
import com.isej.ISEJ.api.response.UserResponse;
import com.isej.ISEJ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    //GET
    @GetMapping("/users")
    public java.util.List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    //login get

    //POST
    @PostMapping("/register")
   public UserResponse addUser(@RequestBody UserRequest userReq){
        return userService.addUser(userReq);
    }

    //PUT

}
