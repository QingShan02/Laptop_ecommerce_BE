package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_product")
	@SequenceGenerator(name = "generator_product", sequenceName = "product_id_seq", allocationSize = 1)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String ram;
	@Column
	private String display;
	@Column
	private String rom;
	@Column
	private String os;
	@Column
	private double price;
	@Column
	private int quantity;
	@Column(name = "brandid")
	private int brandId;
	@Column(name = "colorid")
	private int colorId;
	@Column
	private String logo;

	@ManyToOne
	@JoinColumn(name = "brandid", insertable = false, updatable = false)
	private Brand brand;

	@OneToOne
	@JoinColumn(name = "colorid", insertable = false, updatable = false)
	private Color color;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Cart> carts;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Order_Detail> order_Details;

	@Column
	private Date publishedDate = new Date();
}
