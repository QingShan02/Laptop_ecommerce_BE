package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order_Detail {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonIgnore
    private Orders order;

    @Id
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    @Column
    private int quantity;
}
