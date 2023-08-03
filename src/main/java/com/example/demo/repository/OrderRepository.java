package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByCustomerId(int customerId);
}
