package com.example.demo.service;


import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity newUser);

    UserEntity findById(long id);

    UserEntity update(UserEntity user);

    List<UserEntity> findAllActiveUsers();

    List<UserEntity> findAll();
}
