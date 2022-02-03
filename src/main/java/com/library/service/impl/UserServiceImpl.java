package com.library.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.User;
import com.library.repository.UserRepository;
import com.library.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	/**
	 * To get all users
	 */
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	/**
	 * To add a new user
	 */
	@Override
	@Transactional
	public void addUser(User user) {
		userRepo.save(user);
	}

	/**
	 * To delete an existing user
	 */
	@Override
	public boolean deleteUser(int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			userRepo.delete(user.get());
			return true;
		}

		return false;
	}

}
