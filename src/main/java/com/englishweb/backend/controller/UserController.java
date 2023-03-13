package com.englishweb.backend.controller;

import com.englishweb.backend.entity.Role;
import com.englishweb.backend.repository.RoleRepository;
import com.englishweb.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	void newUser(@RequestBody User newUser){
		 userService.saveOrUpdateUser(newUser);
	}

	@GetMapping("/list")
	List<User> showUser(){
		return userService.findAll();
	}
	
}
