package com.example.writingplatformapi.services;

import com.example.writingplatformapi.exception.UserexistedException;
import com.example.writingplatformapi.models.User;
import com.example.writingplatformapi.models.UserRepository;
import com.example.writingplatformapi.models.UserResponseDto;
import com.example.writingplatformapi.utils.PasswordUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) throws UserexistedException {
        if (userRepository.existsUserByEmail(user.getEmail())) {
            throw new UserexistedException(user.getEmail());
        }
        user.setPassword(PasswordUtils.encodePassword(user.getPassword()));
        return userRepository.save(user);
    }

    public UserResponseDto getById(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.id = user.getId();
        userResponseDto.email = user.getEmail();
        userResponseDto.name = user.getName();
        return userResponseDto;
    }

}
