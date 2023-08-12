package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Orders;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private CartRepository cartRepository;


    public List<OrderDto> findAll() {
        // TODO Auto-generated method stub
        return orderRepository.findAll().stream().map(s->new OrderDto(s)).toList();
    }

    public List<Orders> findByCustomerId(int customerId){
        return orderRepository.findByCustomerId(customerId);
    } 

    public int save (Orders order){
        Orders od = orderRepository.save(order);
        if(od != null){
            order.getOrder_details().forEach(s->{
                s.setOrder(od);
            });
            System.out.println(3425443);
            orderDetailRepository.saveAll(order.getOrder_details());
            order.getOrder_details().forEach(s->{
                cartRepository.deleteById(s.getCartId());
            });
            return 1;
        }
        return 0;
    }
}
