package com.example.demo.dao.impl;

import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManager entityManager;

    @Autowired
    public ProductDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public ProductEntity update(ProductEntity theProduct) {


        return entityManager.merge(theProduct);
    }

    @Override
    public ProductEntity findById(int productId) {

        return entityManager.find(ProductEntity.class, productId);
    }

    @Override
    public List<ProductEntity> findAll(){
        TypedQuery<ProductEntity> theQuery = entityManager.createQuery("from ProductEntity", ProductEntity.class);

        List<ProductEntity> products = theQuery.getResultList();

        return products;
    }
}
