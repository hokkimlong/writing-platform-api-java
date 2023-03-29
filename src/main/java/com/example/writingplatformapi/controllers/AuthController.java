package com.example.writingplatformapi.controllers;

import com.example.writingplatformapi.exception.UserexistedException;
import com.example.writingplatformapi.models.*;
import com.example.writingplatformapi.services.AuthService;
import com.example.writingplatformapi.services.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Auth")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;


    private final TokenService tokenService;


    public AuthController(AuthService authService, UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @RequestMapping("/login")
    public AuthResponseDto login(@RequestBody User user) {
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        User authUser = userRepository.findByEmail(user.getEmail());
        return new AuthResponseDto(tokenService.generateToken(authentication,authUser),authUser);
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

    @GetMapping("/me")
    public User getMe(){
        User user = authService.getCurrentUser();
        return user;
    }
}
