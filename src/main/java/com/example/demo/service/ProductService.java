package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.enums.InvalidRequestParameter;
import com.example.demo.entity.Product;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.model.ProductFilter;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService implements BaseService<Product, Integer> {
	@Autowired
	ProductRepository repo;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product findById(Integer id) throws InvalidRequestParameterException {
		// TODO Auto-generated method stub
		return repo.findById(id)
				.orElseThrow(() -> new InvalidRequestParameterException("id", InvalidRequestParameter.NOTHING));
	}

	public List<Product> findByName(String keyword) {
		return repo.findByName('%' + keyword + '%');
	}

	public List<Product> filterProduct(ProductFilter data) {
	    List<Product> products = this.findAll();

	    if (!data.getRam().isEmpty()) {
	        products = products.stream()
	            .filter(product -> product.getRam().equals(data.getRam()))
	            .collect(Collectors.toList());
	    }

	    if (!data.getRom().isEmpty()) {
	        products = products.stream()
	            .filter(product -> product.getRom().equals(data.getRom()))
	            .collect(Collectors.toList());
	    }

	    if (!data.getDisplay().isEmpty()) {
	        products = products.stream()
	            .filter(product -> product.getDisplay().equals(data.getDisplay()))
	            .collect(Collectors.toList());
	    }

	    if (!data.getOs().isEmpty()) {
	        products = products.stream()
	            .filter(product -> product.getOs().equals(data.getOs()))
	            .collect(Collectors.toList());
	    }
	    
	    if (data.getBrandid() != null) {
	        products = products.stream()
	            .filter(product -> product.getBrand().getId() == data.getBrandid())
	            .collect(Collectors.toList());
	    }

	    return products;
	}
}
