package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order_Detail;
import com.example.demo.entity.Product;

public interface OrderDetailRepository extends JpaRepository<Order_Detail, Integer>{
    
}
