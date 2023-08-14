package com.example.demo.repository;

import com.example.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order_Detail;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<Order_Detail, Integer>{
    @Query("SELECT NEW com.example.demo.entity.Report(pro.id, pro.name, pro.logo, " +
            "       SUM(ord_de.quantity), SUM(pro.price)) " +
            "FROM Order_Detail ord_de " +
            "JOIN ord_de.product pro " +
            "JOIN ord_de.order ord " +
            "WHERE ord.buyDate BETWEEN :startDate AND :endDate " +
            "GROUP BY pro.id")
    List<Report> productsSold(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
