package com.bookstore.api.model.mapper;

import com.bookstore.api.model.dto.UserDTO;
import com.bookstore.api.model.entity.User;

public class UserMapper {
    public static UserDTO toDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .build();
    }

    public static User toEntity(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .address(userDTO.getAddress())
                .build();
    }
}
