package com.library.service;

import java.util.List;

import com.library.entity.User;

public interface UserService {

	List<User> getUsers();

	void addUser(User user);

	boolean deleteUser(int id);
}
