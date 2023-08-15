package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.enums.InvalidRequestParameter;
import com.example.demo.entity.Users;
import com.example.demo.exception.InvalidRequestParameterException;
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
	public Users findById(Integer id) throws InvalidRequestParameterException {
		// TODO Auto-generated method stub
		return usersRepository.findById(id)
				.orElseThrow(() -> new InvalidRequestParameterException("id", InvalidRequestParameter.NOTHING));
	}

	public Users login(String email, String password) throws InvalidRequestParameterException {
		// TODO Auto-generated method stub
		usersRepository.findByEmail(email)
				.orElseThrow(() -> new InvalidRequestParameterException("EMAIL", InvalidRequestParameter.NOT_EXISTS));
		return usersRepository.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new InvalidRequestParameterException("PASSWORD", InvalidRequestParameter.WRONG));
	}

	public List<Users> findByIsAdmin(Boolean isAdmin) {
		return usersRepository.findByIsAdmin(isAdmin);
	}

	public Users register(Users user) throws InvalidRequestParameterException {
		if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new InvalidRequestParameterException("User",
					InvalidRequestParameter.EXISTS);
		}
		return usersRepository.save(user);
	}

	public int save(Users user) throws InvalidRequestParameterException {
		if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new InvalidRequestParameterException("User",
					InvalidRequestParameter.EXISTS);
		}
		usersRepository.save(user);
		return 1;
	}

	public int deleteById(Integer id) throws InvalidRequestParameterException {
		if (!usersRepository.existsById(id)) {
			throw new InvalidRequestParameterException("id", InvalidRequestParameter.NOT_FOUND);
		}
		usersRepository.delete(usersRepository.findById(id).get());
		return 1;
	}

	public int update(Users user) throws InvalidRequestParameterException {
		if (!usersRepository.existsById(user.getId())) {
			throw new InvalidRequestParameterException("User", InvalidRequestParameter.NOT_EXISTS);
		}
		usersRepository.save(user);
		return 1;
	}

	public List<Users> customersBuyMostInMonth() {
		return usersRepository.customersBuyMostInMonth();
	}
}
