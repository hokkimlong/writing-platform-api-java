package com.example.writingplatformapi.models;

public class AuthResponseDto {
    public String token;
    public UserResponseDto user;

    public AuthResponseDto(String token,User user) {
        this.token = token;
        this.user = new UserResponseDto();
        this.user.name = user.getName();
        this.user.email = user.getEmail();
        this.user.id = user.getId();
    }
}
