package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Report;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    public List<Report> productsSold(Date startDate, Date endDate) {
        return orderDetailRepository.productsSold(startDate, endDate);
    }
}
