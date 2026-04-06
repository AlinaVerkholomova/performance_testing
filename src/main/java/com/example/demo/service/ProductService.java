package com.example.demo.service;

import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity update(ProductEntity product);

    ProductEntity findById(int ProductId);

    List<ProductEntity> findAll();
}
