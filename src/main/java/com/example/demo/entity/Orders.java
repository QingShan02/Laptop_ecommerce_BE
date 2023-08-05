package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private Date buyDate = new Date();
	@Column
	private String place;

	@Column
	private int status;

	@Column(name = "customerid")
	private int customerId;

	@OneToMany(mappedBy = "order",cascade = CascadeType.DETACH)
	private List<Order_Detail> order_details;
}
