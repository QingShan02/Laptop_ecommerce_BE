package com.example.demo.controller;

import com.example.demo.entity.Brand;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.service.BrandService;
import com.example.demo.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/color")
public class ColorController {
	@Autowired
	ColorService colorService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws InvalidRequestParameterException {
		return ResponseEntity.ok(colorService.findById(id));
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(colorService.findAll());
	}
}
