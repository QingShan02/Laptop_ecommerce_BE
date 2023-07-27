package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String ram;

	private String display;

	private String rom;

	private Date puslishedDate;

	private String os;

	private double price;

	private int quantity;

	private String logo;
	
    @ManyToOne
    @JoinColumn(name = "brandid", insertable = false, updatable = false)
    private Brand brand;
}
