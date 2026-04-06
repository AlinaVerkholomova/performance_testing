package com.example.demo.service;

import com.example.demo.entity.OrderEntity;
import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    List<OrderEntity> findOrderHistory(String userId, LocalDate startDate, LocalDate endDate, String status);
}