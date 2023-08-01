package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) throws InvalidRequestParameterException{
        return ResponseEntity.ok(productService.findById(id));
    }
}
