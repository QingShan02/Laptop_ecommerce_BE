package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.service.UsersService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	@GetMapping(value = { "/", "" })
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(usersService.findAll());
	}

	@GetMapping(value = "/customer")
	public ResponseEntity<?> getAllCustomer() {
		return ResponseEntity.ok(usersService.findByIsAdmin(false));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) throws InvalidRequestParameterException {
		return ResponseEntity.ok(usersService.findById(id));
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Users user) throws InvalidRequestParameterException {
		return ResponseEntity.ok(usersService.save(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws InvalidRequestParameterException {
		return ResponseEntity.ok(usersService.deleteById(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Users user) throws InvalidRequestParameterException {
		return ResponseEntity.ok(usersService.update(user));
	}

	@GetMapping("/customers-buy-most-in-month")
	public ResponseEntity<?> customersBuyMostInMonth() {
		return ResponseEntity.ok(usersService.customersBuyMostInMonth());
	}
}
