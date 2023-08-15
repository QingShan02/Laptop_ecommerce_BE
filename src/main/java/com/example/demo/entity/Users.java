package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "users_id_seq", allocationSize = 1)
	@Column
	private int id;

	@Column
	private String password;

	@Column
	private String fullname;

	@Column
	private String email;

	@Column
	private String phone;

	@Column(name = "is_admin")
	private boolean isAdmin;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Orders> orders;

	public Users(int id, String password, String fullname, String email, String phone) {
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.isAdmin = false;
	}
}
