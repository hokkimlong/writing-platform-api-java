package com.example.writingplatformapi.controllers;

import com.example.writingplatformapi.exception.UserexistedException;
import com.example.writingplatformapi.models.ResponseDto;
import com.example.writingplatformapi.models.User;
import com.example.writingplatformapi.models.UserResponseDto;
import com.example.writingplatformapi.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Auth")
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping("/login")
    public User login() {
        return null;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> register(@RequestBody User user) {
        try {
            return new ResponseEntity<>(new ResponseDto("Register success", authService.register(user)),HttpStatus.OK);
        } catch (UserexistedException e) {
            return new ResponseEntity<>(new ResponseDto(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/logout")
    public User logout() {
        return null;
    }

    @RequestMapping("/user/{id}")
    public UserResponseDto getUserById(@PathVariable int id) {
       return authService.getById(id);
    }
}
