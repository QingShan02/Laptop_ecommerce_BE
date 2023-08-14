package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Orders;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.model.MailInfo;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

import jakarta.mail.MessagingException;

@Service
public class OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UsersService usersService;

    @Autowired
    private EmailService emailService;

    public Orders findById(Integer id){
        return orderRepository.findById(id).get();
    }

    public List<OrderDto> findAll() {
        // TODO Auto-generated method stub
        return orderRepository.findAll().stream().map(s->new OrderDto(s)).toList();
    }

    public List<Orders> findByCustomerId(int customerId){
        return orderRepository.findByCustomerId(customerId);
    } 

    public int save (Orders order) throws MessagingException{
        try {
            order.setUser(usersService.findById(order.getCustomerId()));
        } catch (InvalidRequestParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Orders od = orderRepository.save(order);
        if(od != null){
            order.getOrder_details().forEach(s->{
                s.setOrder(od);
            });
            od.setOrder_details(order.getOrder_details());
            System.out.println(3425443);
            orderDetailRepository.saveAll(order.getOrder_details());
            order.getOrder_details().forEach(s->{
                cartRepository.deleteById(s.getCartId());
            });
            emailService.send(new MailInfo(order.getUser().getEmail(), "Hóa đơn Zuhot Store", od));
            return 1;
        }
        return 0;
    }
}
