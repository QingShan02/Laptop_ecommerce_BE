package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderSerivce implements BaseService<Orders,Integer>{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orders> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Orders findById(Integer id) throws InvalidRequestParameterException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public List<Orders> findByCustomerId(int customerId){
        return orderRepository.findByCustomerId(customerId);
    } 
}
