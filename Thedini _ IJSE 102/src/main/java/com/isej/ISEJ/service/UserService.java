package com.isej.ISEJ.service;

import com.isej.ISEJ.api.Entitiy.User;
import com.isej.ISEJ.api.repository.UserRepository;
import com.isej.ISEJ.api.request.UserRequest;
import com.isej.ISEJ.api.response.UserResponse;
import com.isej.ISEJ.api.response.stockResponse;
import com.isej.ISEJ.api.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    //GET
    public List<UserResponse> getAllUsers() {
        List<UserResponse> UserResponseList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
           UserResponse userResponse = UserUtils.mapToResponse(user);
            UserResponseList.add(userResponse);
        }
        return UserResponseList;
    }

    //POST
    public UserResponse addUser(UserRequest userReq) {

        User user = User.builder()
                .id(userReq.getId())
                .username(userReq.getUsername())
                .email(userReq.getEmail())
                .role(userReq.getRole())
                .password(userReq.getPassword())
                .build();
        return UserUtils.mapToResponse(userRepository.save(user));
    }
}
