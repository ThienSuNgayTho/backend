package com.englishweb.backend.controller;

import com.englishweb.backend.entity.Role;
import com.englishweb.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/role")
	Role newRole(@RequestBody Role newRole) {
		return roleRepository.save(newRole) ;
	}

	@PostMapping("/user")
	User newUser(@RequestBody User newUser){
		return userRepository.save(newUser);
	}
	
}
