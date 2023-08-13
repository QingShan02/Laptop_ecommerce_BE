package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders;
@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "select o from Orders o where o.user.id = :customerId")
    List<Orders> findByCustomerId(int customerId);
}
