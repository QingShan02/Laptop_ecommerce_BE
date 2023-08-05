package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int cartId;

	@ManyToOne
	@JoinColumn(name="productid",insertable = true,updatable = false)
	private Product product;

	// @Column(name = "productid")
	@Transient
	private int productId;

	@Column(name = "userid")
	private int userId;

	@Column
	private int quantity;
}
