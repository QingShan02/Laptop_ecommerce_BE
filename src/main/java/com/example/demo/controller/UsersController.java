package com.example.demo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@GetMapping(value = {"/",""})
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(usersService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) throws InvalidRequestParameterException{
		return ResponseEntity.ok(usersService.findById(id));
	}
}
