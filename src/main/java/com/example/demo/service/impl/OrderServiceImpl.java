package com.example.demo.service.impl;

import com.example.demo.dao.OrderDAO;
import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public List<OrderEntity> findOrderHistory(String userId, LocalDate startDate, LocalDate endDate, String status) {
        return orderDAO.findOrderHistory(userId, startDate, endDate, status);
    }
}