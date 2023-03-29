package com.example.writingplatformapi.services;

import com.example.writingplatformapi.models.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       com.example.writingplatformapi.models.User user  =  userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        UserDetails authenticatedUser = User.withUsername(user.getEmail()).password(user.getPassword()).authorities("USER").build();
        return authenticatedUser;
    }
}
