package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Users;
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

	@Query(value = "SELECT pro.id, pro.name, ram, display, rom, os, price, pro.quantity, pro.brandid, pro.colorid, pro.logo\n" +
			"FROM order_detail ord_de JOIN product pro ON ord_de.productid = pro.id\n" +
			"GROUP BY pro.id, pro.name, ram, display, rom, os, price, pro.quantity, pro.brandid, pro.colorid,  pro.logo\n" +
			"HAVING SUM(ord_de.quantity) = (\n" +
			"    SELECT MAX(total_quantity)\n" +
			"    FROM (\n" +
			"        SELECT productid, SUM(quantity) AS total_quantity\n" +
			"        FROM order_detail\n" +
			"        GROUP BY productid\n" +
			"    ) AS subquery\n" +
			");", nativeQuery = true)
	List<Product> productsBuyMostInMonth();
}
