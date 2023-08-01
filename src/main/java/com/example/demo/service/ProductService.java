package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductService implements BaseService<Product,Integer> {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) throws InvalidRequestParameterException {
        // TODO Auto-generated method stub
        return productRepository.findById(id).get();
    }
    
}
