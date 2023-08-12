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
	public int id;
	@Column
	private Date buyDate = new Date();
	@Column
	private String place;

	@Column
	private int status;

	@ManyToOne
	@JoinColumn(name = "customerid")
	private Users user;

	@OneToMany(mappedBy = "order",cascade = CascadeType.DETACH)
	private List<Order_Detail> order_details;
}
