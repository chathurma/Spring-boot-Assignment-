package com.isej.ISEJ.api.utils;

import com.isej.ISEJ.api.Entitiy.User;
import com.isej.ISEJ.api.response.UserResponse;

public class UserUtils {
    public static UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .password(user.getPassword())
                .build();
    }
}
