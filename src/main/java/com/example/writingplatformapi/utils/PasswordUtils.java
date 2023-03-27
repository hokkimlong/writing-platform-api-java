package com.example.writingplatformapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public static boolean passwordsMatch(String userEnteredPassword, String hashedPassword) {
        return passwordEncoder.matches(userEnteredPassword, hashedPassword);
    }
}