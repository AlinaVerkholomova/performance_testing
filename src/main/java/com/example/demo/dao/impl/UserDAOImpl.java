package com.example.demo.dao.impl;


import com.example.demo.dao.UserDAO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public UserEntity createUser(UserEntity newUser) {
        UserEntity theUser = entityManager.merge(newUser);

        return theUser;
    }

    @Override
    public UserEntity findById(long id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return entityManager.merge(user);
    }

    @Override
    public List<UserEntity> findAllActiveUsers() {
        StringBuilder jpql = new StringBuilder("SELECT o FROM UserEntity o WHERE o.status = 'active'");


        TypedQuery<UserEntity> theQuery = entityManager.createQuery(jpql.toString(), UserEntity.class);

        List<UserEntity> activeUsers = theQuery.getResultList();

        return activeUsers;
    }

    @Override
    public List<UserEntity> findAll() {
        TypedQuery<UserEntity> theQuery = entityManager.createQuery("from UserEntity", UserEntity.class);

        List<UserEntity> users = theQuery.getResultList();

        return users;
    }

}
