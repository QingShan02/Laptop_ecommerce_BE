package com.example.demo.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.enums.InvalidRequestParameter;
import com.example.demo.entity.Product;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.model.ProductFilter;
import com.example.demo.repository.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class ProductService implements BaseService<Product, Integer> {
	@Autowired
	ProductRepository repo;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Product> findAll() {
		return repo.findAll();
	}

	@Override
	public Product findById(Integer id) throws InvalidRequestParameterException {
		return repo.findById(id)
				.orElseThrow(() -> new InvalidRequestParameterException("id", InvalidRequestParameter.NOTHING));
	}

	public List<Product> filterProduct(ProductFilter p) {
		String query = "SELECT o FROM Product o JOIN Brand b ON o.brand.id = b.id " + "WHERE o.brand.id = :brandid "
				+ "AND o.ram = :ram " + "AND o.rom = :rom " + "AND o.os = :os " + "AND o.display = :display";

		if (p.getBrandid().isBlank())
			query = Pattern.compile(":brandid").matcher(query).replaceAll("o.brand.id");
		if (p.getRam().isBlank())
			query = Pattern.compile(":ram").matcher(query).replaceAll("o.ram");
		if (p.getRom().isBlank())
			query = Pattern.compile(":rom").matcher(query).replaceAll("o.rom");
		if (p.getDisplay().isBlank())
			query = Pattern.compile(":display").matcher(query).replaceAll("o.display");
		if (p.getOs().isBlank())
			query = Pattern.compile(":os").matcher(query).replaceAll("o.os");

		TypedQuery<Product> type = entityManager.createQuery(query, Product.class);

		if (!p.getBrandid().isBlank())
			type.setParameter("brandid", p.getBrandid().strip());
		if (!p.getRam().isBlank())
			type.setParameter("ram", p.getRam().strip());
		if (!p.getRom().isBlank())
			type.setParameter("rom", p.getRom().strip());
		if (!p.getDisplay().isBlank())
			type.setParameter("display", p.getDisplay().strip());
		if (!p.getOs().isBlank())
			type.setParameter("os", p.getOs().strip());

		return type.getResultList();
	}
}
