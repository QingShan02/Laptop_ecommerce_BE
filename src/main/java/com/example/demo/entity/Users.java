package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "user_generator")
	@SequenceGenerator(name="user_generator", sequenceName = "users_id_seq", allocationSize=1)
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
	
	@Column(name="is_admin")
	private boolean isAdmin;
}
