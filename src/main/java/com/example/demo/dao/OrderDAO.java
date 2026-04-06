package com.example.demo.dao;

import com.example.demo.entity.OrderEntity;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {
    List<OrderEntity> findOrderHistory(String userId, LocalDate startDate, LocalDate endDate, String status);
}