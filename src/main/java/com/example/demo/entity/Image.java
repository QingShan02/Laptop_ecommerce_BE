package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String url;

	@Column(name = "productid")
	private int productId;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "productid", insertable = false, updatable = false)
	Product product;
}
