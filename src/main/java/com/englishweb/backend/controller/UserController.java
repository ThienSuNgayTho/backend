package com.englishweb.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser){
		return userRepository.save(newUser);
	}

	@GetMapping("/list")
	List<User> showUser(){
		return userService.findAll();
	}
	
	@GetMapping("/user/list")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
}
