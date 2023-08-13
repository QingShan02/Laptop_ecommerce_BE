package com.example.demo.entity;

import com.example.demo.listener.MyEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Report {
    private int productId;
    private String productName;
    private String productLogo;
    private Long totalQuantity;
    private Double totalPrice;
}
