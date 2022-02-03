package com.library.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.UserDto;
import com.library.entity.User;
import com.library.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ModelMapper mapper;

	/**
	 * To get list of all existing users in the database
	 * 
	 * @return
	 */
	@GetMapping("getUsers")
	public List<UserDto> getUsers() {

		List<User> users = userService.getUsers();
		if (!users.isEmpty()) {
			return users.stream().map(item -> mapper.map(item, UserDto.class)).collect(Collectors.toList());
		}
		return null;
	}

	/**
	 * To add a new user to the database
	 * 
	 * @param userDto
	 * @return
	 */
	@PostMapping("addUser")
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
		userService.addUser(mapper.map(userDto, User.class));
		return new ResponseEntity<String>("User Saved Successfully", HttpStatus.OK);
	}

	/**
	 * To delete an existing user from the database
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int id) {
		boolean response = userService.deleteUser(id);
		if (response) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deletion failed. Please check ID", HttpStatus.BAD_REQUEST);
	}
}
