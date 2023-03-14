package com.englishweb.backend.controller;

// <<<<<<< HEAD
// import com.englishweb.backend.entity.Role;
// import com.englishweb.backend.repository.RoleRepository;
// import com.englishweb.backend.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// =======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// >>>>>>> f212eca (add test entity, connect into cloudinary)
import com.englishweb.backend.entity.User;
import com.englishweb.backend.repository.UserRepository;
import com.englishweb.backend.service.UserService;

import java.util.List;

// @RestController
// <<<<<<< HEAD
// @CrossOrigin("http://localhost:3000")
// public class UserController {

// 	@Autowired
// 	

// =======
@CrossOrigin
public class UserController {


	@Autowired
	private UserService userService;
	private UserRepository userRepository;
	
// >>>>>>> f212eca (add test entity, connect into cloudinary)
	@PostMapping("/user")
	void newUser(@RequestBody User newUser){
		 userService.saveOrUpdateUser(newUser);
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
