package com.englishweb.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.englishweb.backend.entity.Role;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.repository.UserRepository;
import com.englishweb.backend.service.UserService;
import com.englishweb.backend.service.UserServiceImpl;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@PutMapping("/update/user/{userId}")
	ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable (name = "userId") int id) {
		User us = userService.findUserById(id);
		us.setUsername(user.getUsername());
		us.setPassword(encoder.encode(user.getPassword()));
		us.setEmail(user.getEmail());
		us.setFullName(user.getFullName());
		us.setAddress(user.getAddress());
		us.setPhoneNumber(user.getPhoneNumber());
		us.setLevel(user.getLevel());
		us.setRoles(user.getRoles());
		us.setStatus(user.getStatus());

		userService.saveOrUpdateUser(us);
		return new ResponseEntity(us,HttpStatus.OK);
	}

	@GetMapping("/list")
	List<User> showUser() {
		return userService.findAll();
	}

	@GetMapping("/user/list")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
