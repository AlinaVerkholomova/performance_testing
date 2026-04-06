package com.example.demo.service.impl;

import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDao;

    @Autowired
    public ProductServiceImpl(ProductDAO newProduct){
        productDao = newProduct;
    }

    @Transactional
    @Override
    public ProductEntity update(ProductEntity newProduct) {
        return productDao.update(newProduct);
    }

    @Transactional
    @Override
    public ProductEntity findById(int productId) {
        return productDao.findById(productId);
    }

    @Transactional
    @Override
    public List<ProductEntity> findAll() {
        return productDao.findAll();
    }
}
