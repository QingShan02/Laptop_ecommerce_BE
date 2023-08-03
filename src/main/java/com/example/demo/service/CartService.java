package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public int save(Cart cart) {
        cart.setProduct(productRepository.findById(cart.getProductId()).get());
        Cart object = cartRepository.save(cart);
        if (object == null) {
            return 1;
        }
        return 0;
    }

    public List<Cart> findByUserId(int id) {
        return cartRepository.findByUserId(id);
    }

    public int deleteById(int id) {
        try {
            cartRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}