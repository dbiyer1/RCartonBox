package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.User;
import com.library.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("getUsers")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("addUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("User Saved Successfully", HttpStatus.OK);
	}

	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int id) {
		boolean response = userService.deleteUser(id);
		if (response) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deletion failed. Please check ID", HttpStatus.BAD_REQUEST);
	}
}
