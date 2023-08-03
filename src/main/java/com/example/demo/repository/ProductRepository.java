package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	List<Product> findByName(String name);

	@Query("SELECT o FROM Product o JOIN Brand b ON o.brand.id = b.id WHERE o.ram = "
			+ "CASE WHEN ?1 IS NULL THEN o.ram ELSE ?1 END "
			+ "AND o.rom = "
			+ "CASE WHEN ?2 IS NULL THEN o.rom ELSE ?2 END "
			+ "AND o.display = "
			+ "CASE WHEN ?3 IS NULL THEN o.display ELSE ?3 END "
			+ "AND o.os = "
			+ "CASE WHEN ?4 IS NULL THEN o.os ELSE ?4 END "
			+ "AND o.brand.id = "
			+ "CASE WHEN ?5 IS NULL THEN o.brand.id ELSE ?5 END")
	List<Product> filterProduct(String ram, String rom, String display,String os, Integer brandid);
}
