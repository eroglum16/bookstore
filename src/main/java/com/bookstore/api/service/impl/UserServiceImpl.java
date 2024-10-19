package com.bookstore.api.service.impl;

import com.bookstore.api.config.SecurityConfig;
import com.bookstore.api.model.dto.UserDTO;
import com.bookstore.api.model.entity.User;
import com.bookstore.api.model.mapper.UserMapper;
import com.bookstore.api.repository.UserRepository;
import com.bookstore.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserDTO register(UserDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        user.setPassword(SecurityConfig.passwordEncoder().encode(userDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }
}
