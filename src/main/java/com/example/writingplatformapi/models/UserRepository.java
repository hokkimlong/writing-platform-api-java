package com.example.writingplatformapi.models;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    Boolean existsUserByEmail(String email);
}
