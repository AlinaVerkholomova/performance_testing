package com.example.demo.service.impl;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        userDao = userDAO;
    }

    @Transactional
    @Override
    public UserEntity createUser(UserEntity newUser) {
        return userDao.createUser(newUser);
    }

    @Transactional
    @Override
    public UserEntity findById(long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public UserEntity update(UserEntity user) {
        return userDao.update(user);
    }


    @Transactional
    @Override
    public List<UserEntity> findAllActiveUsers() {
        return userDao.findAllActiveUsers();
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }


}
