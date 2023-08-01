package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.service.BrandService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class BrandController {
	@Autowired
	BrandService brandService;
	
	@GetMapping("/brand/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws InvalidRequestParameterException {
		return ResponseEntity.ok(brandService.findById(id));
	}
	
	@GetMapping("/brands")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(brandService.findAll());
	}
}
