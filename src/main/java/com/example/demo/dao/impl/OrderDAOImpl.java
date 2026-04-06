package com.example.demo.dao.impl;

import com.example.demo.dao.OrderDAO;
import com.example.demo.entity.OrderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private final EntityManager entityManager;

    @Autowired
    public OrderDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<OrderEntity> findOrderHistory(String userId, LocalDate startDate, LocalDate endDate, String status) {
        StringBuilder jpql = new StringBuilder("SELECT o FROM OrderEntity o WHERE o.userId = :userId");

        if (startDate != null) {
            jpql.append(" AND o.orderDate >= :startDate");
        }

        if (endDate != null) {
            jpql.append(" AND o.orderDate <= :endDate");
        }

        if (status != null && !status.isBlank()) {
            jpql.append(" AND o.status = :status");
        }

        jpql.append(" ORDER BY o.orderDate DESC");

        TypedQuery<OrderEntity> query = entityManager.createQuery(jpql.toString(), OrderEntity.class);
        query.setParameter("userId", userId);

        if (startDate != null) {
            query.setParameter("startDate", startDate);
        }

        if (endDate != null) {
            query.setParameter("endDate", endDate);
        }

        if (status != null && !status.isBlank()) {
            query.setParameter("status", status);
        }

        return query.getResultList();
    }
}