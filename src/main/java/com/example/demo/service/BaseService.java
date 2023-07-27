package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exception.InvalidRequestParameterException;

public interface BaseService<E,T>{
	
	public List<E> findAll();
	
	public E findById(T id) throws InvalidRequestParameterException;
}
