package com.example.demo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Product;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.service.ProductService;
@Controller
public class TestJUnit {
	@Autowired
	ProductService productService;
	
	@Test
	public Product index() throws InvalidRequestParameterException {
		Product product = new Product();
		System.out.println(productService.findById(1));
		return productService.findById(1);
	}
	
	@Test
	public void testSetup() {
		String str= "I am done with JUnit Setup";
		assertEquals("I am done with JUnit Setup",str);
	}
}
