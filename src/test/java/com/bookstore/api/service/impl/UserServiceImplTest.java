package com.bookstore.api.service.impl;

import static org.mockito.Mockito.*;

import com.bookstore.api.model.dto.UserDTO;
import com.bookstore.api.model.entity.User;
import com.bookstore.api.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void register_ShouldEncodePassword() {
        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .username("test")
                .password("pass")
                .firstName("Test")
                .lastName("User")
                .build();

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        UserDTO savedUser = userService.register(userDTO);

        Assertions.assertNotEquals(userDTO.getPassword(), savedUser.getPassword());
    }

}
