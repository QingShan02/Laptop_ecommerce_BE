package com.example.demo.model;

import com.example.demo.entity.Orders;

import lombok.Data;
@Data
public class MailInfo {
	String from;
	String to;
	String subject;
	Orders body;

	public MailInfo(String to, String subject, Orders body) {
		this.from = "Zuhot Store <zuhot@gmail.com>";
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

}
