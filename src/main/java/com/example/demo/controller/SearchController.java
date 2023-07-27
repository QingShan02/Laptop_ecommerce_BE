package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductFilter;
import com.example.demo.service.BrandService;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class SearchController {
	@Autowired
	ProductService productService;
	@Autowired
	BrandService brandService;

	@GetMapping("/search")
	public ResponseEntity<?> findByProductNameOrBrandName(@RequestParam("keyword") String key) {
		return ResponseEntity.ok(productService.findByName(key));
	}

	@PostMapping("/product/filter")
	public ResponseEntity<?> filterProduct(@RequestBody Optional<ProductFilter> data) {
		return ResponseEntity.ok(productService.filterProduct(data.get()));
	}

	@GetMapping("/products")
	public ResponseEntity<?> getAllProduct() {
		return ResponseEntity.ok(productService.findAll());
	}
	
	@GetMapping("/brands")
	public ResponseEntity<?> getAllBrands() {
		return ResponseEntity.ok(brandService.findAll());
	}
}
