package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.enums.InvalidRequestParameter;
import com.example.demo.entity.Product;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.repository.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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

	public List<Product> filterProduct(String ram, String rom, String display, String os, Integer brandid) {
		return repo.filterProduct(ram, rom, display, os, brandid);
	}
}
