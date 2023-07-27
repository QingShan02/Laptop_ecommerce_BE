package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.enums.InvalidRequestParameter;
import com.example.demo.entity.Brand;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.repository.BrandRepository;

@Service
public class BrandService implements BaseService<Brand, Integer> {
	@Autowired
	BrandRepository repo;

	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Brand findById(Integer id) throws InvalidRequestParameterException {
		// TODO Auto-generated method stub
		return repo.findById(id)
				.orElseThrow(() -> new InvalidRequestParameterException("id", InvalidRequestParameter.NOTHING));
	}

}
