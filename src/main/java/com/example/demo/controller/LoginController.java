package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.model.LoginInput;
import com.example.demo.service.UsersService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/auth")
public class LoginController {
	@Autowired
	private UsersService usersService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginInput data) throws InvalidRequestParameterException {
		return ResponseEntity.ok(usersService.login(data.getEmail(), data.getPassword()));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Users data) throws InvalidRequestParameterException {
		return ResponseEntity.ok(usersService.register(data));
	}
}
