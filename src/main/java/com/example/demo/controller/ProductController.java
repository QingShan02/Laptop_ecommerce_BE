package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.model.ProductFilter;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<?> getAllProduct() {
		return ResponseEntity.ok(productService.findAll());
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws InvalidRequestParameterException {
		return ResponseEntity.ok(productService.findById(id));
	}
	
	@PostMapping("/product/filter")
	public ResponseEntity<?> filterProduct(@RequestBody Optional<ProductFilter> data) {
		return ResponseEntity.ok(productService.filterProduct(data.get()));
	}
}
