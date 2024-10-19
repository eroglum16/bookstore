package com.bookstore.api.service;

import com.bookstore.api.model.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
}
