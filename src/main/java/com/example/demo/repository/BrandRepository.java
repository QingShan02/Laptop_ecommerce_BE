package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	Brand findByName(String name);
}
