package com.example.demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.example.demo.listener.MyEntityListener;
import com.example.demo.repository.OrderRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Table
@Entity
@EntityListeners(MyEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order_Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;


    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonIgnore
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    @Column
    private int quantity;

    @Transient
    private int cartId;
}
