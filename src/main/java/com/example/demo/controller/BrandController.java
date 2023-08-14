package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Brand;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.service.BrandService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/brand")
public class BrandController {
	@Autowired
	BrandService brandService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws InvalidRequestParameterException {
		return ResponseEntity.ok(brandService.findById(id));
	}

	@GetMapping({ "/", "" })
	public ResponseEntity<?> getAll(@RequestParam("p") Optional<Integer> p) {
		return ResponseEntity.ok(brandService.findAll(PageRequest.of(p.orElse(0), 3)));
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Brand brand) throws InvalidRequestParameterException {
		return ResponseEntity.ok(brandService.save(brand));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws InvalidRequestParameterException {
		return ResponseEntity.ok(brandService.deleteById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Brand brand)
			throws InvalidRequestParameterException {
		return ResponseEntity.ok(brandService.update(id, brand));
	}
}
