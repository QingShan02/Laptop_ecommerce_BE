package com.example.demo.repository;

import com.example.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order_Detail;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<Order_Detail, Integer>{
    @Query("SELECT NEW com.example.demo.entity.Report(pro.id, pro.name, pro.logo, " +
            "       SUM(ord_de.quantity), SUM(pro.price)) " +
            "FROM Order_Detail ord_de JOIN Product pro ON ord_de.product.id = pro.id " +
            "GROUP BY pro.id")
    List<Report> productsSold();
}
