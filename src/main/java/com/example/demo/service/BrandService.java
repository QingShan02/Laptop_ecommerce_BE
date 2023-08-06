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
		return repo.findAll();
	}

	@Override
	public Brand findById(Integer id) throws InvalidRequestParameterException {
		if (id == null) {
			throw new InvalidRequestParameterException("id", InvalidRequestParameter.NOTHING);
		}
		return repo.findById(id)
				.orElseThrow(() -> new InvalidRequestParameterException("id", InvalidRequestParameter.NOT_FOUND));
	}

	public int save(Brand brand) throws InvalidRequestParameterException {
		if (brand == null) {
			throw new InvalidRequestParameterException("Brand", InvalidRequestParameter.NOTHING);
		}
		Brand br = repo.findByName(brand.getName());
		if (br != null) {
			throw new InvalidRequestParameterException("Brand", InvalidRequestParameter.EXISTS);
		}
		repo.save(brand);
		return 1;
	}

	public int deleteById(Integer id) throws InvalidRequestParameterException {
		if (!repo.existsById(id)) {
			throw new InvalidRequestParameterException("id", InvalidRequestParameter.NOT_FOUND);
		}
		repo.delete(repo.findById(id).get());
		return 1;
	}

	public int update(Brand brand) throws InvalidRequestParameterException {
		if (!repo.existsById(brand.getId())) {
			throw new InvalidRequestParameterException("brand", InvalidRequestParameter.NOT_EXISTS);
		}
		repo.save(brand);
		return 1;
	}
}
