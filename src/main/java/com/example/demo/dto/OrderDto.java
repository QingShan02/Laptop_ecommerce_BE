package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Order_Detail;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Users;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
public class OrderDto {
	private int id;
	private Date buyDate;
	private String place;
	private int status;
	private String customerName;
	private List<Order_Detail> order_details;

    public OrderDto(Orders order){
        this.id = order.getId();
        this.buyDate = order.getBuyDate();
        this.place = order.getPlace();
        this.order_details = order.getOrder_details();
        this.status = order.getStatus();
        this.customerName = order.getUser().getFullname();
    }
}
