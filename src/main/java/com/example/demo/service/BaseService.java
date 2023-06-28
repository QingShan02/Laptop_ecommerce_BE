package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<E,T>{
	
	public List<E> findAll();
	
	public Optional<E> findById(T id);
}
