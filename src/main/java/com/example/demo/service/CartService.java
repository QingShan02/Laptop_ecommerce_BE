package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    
    public int save(Cart cart){
        Cart object = cartRepository.save(cart);
        if(object== null){
            return 1;
        }
        return 0;
    }

    public List<Cart> findByUserId(int id){
        return cartRepository.findByUserId(id);   
    }
}