package com.example.demo.dao;

import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductDAO {

    ProductEntity update(ProductEntity product);

    ProductEntity findById(int productId);

    List<ProductEntity> findAll();
}
