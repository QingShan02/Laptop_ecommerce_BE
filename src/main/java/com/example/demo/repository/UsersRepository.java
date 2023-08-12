package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByEmailAndPassword(String email, String password);
	Optional<Users> findByEmail(String email);
	Optional<Users> findByIsAdmin(Boolean isAdmin);
	Users findByFullname(String name);
}
