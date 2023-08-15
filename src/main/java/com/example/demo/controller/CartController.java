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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.save(cart));  
    }

    @GetMapping("")
    public ResponseEntity<?> findByUserId(@RequestParam("userId") Optional<Integer> id){
        return ResponseEntity.ok(cartService.findByUserId(id.get()));  
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return ResponseEntity.ok(cartService.deleteById(id));
    }
}