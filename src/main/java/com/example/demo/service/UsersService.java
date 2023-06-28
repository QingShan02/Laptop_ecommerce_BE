package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersService implements BaseService<Users, Integer> {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Optional<Users> findById(Integer id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id);
	}

}
