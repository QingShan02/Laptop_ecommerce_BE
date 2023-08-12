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

import com.example.demo.entity.Orders;
import com.example.demo.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderSerivce;

    @GetMapping("")
    public ResponseEntity<?> getAll (@RequestParam("userId") Optional<Integer> userId){ 
        return ResponseEntity.ok(userId.isPresent() ?orderSerivce.findByCustomerId(userId.get()): orderSerivce.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody Orders order){
        return ResponseEntity.ok(orderSerivce.save(order));
    }
}
