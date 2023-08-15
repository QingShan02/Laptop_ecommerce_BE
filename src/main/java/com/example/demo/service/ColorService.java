package com.example.demo.service;

import com.example.demo.common.enums.InvalidRequestParameter;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Color;
import com.example.demo.exception.InvalidRequestParameterException;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements BaseService<Color, Integer> {
	@Autowired
	ColorRepository colorRepository;

	@Override
	public List<Color> findAll() {
		return colorRepository.findAll();
	}

	@Override
	public Color findById(Integer id) throws InvalidRequestParameterException {
		return null;
	}
}
