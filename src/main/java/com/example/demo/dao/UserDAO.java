package com.example.demo.dao;

import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    UserEntity createUser(UserEntity newUser);

    UserEntity findById(long id);

    UserEntity update(UserEntity user);

    List<UserEntity> findAllActiveUsers();

    List<UserEntity> findAll();
}
