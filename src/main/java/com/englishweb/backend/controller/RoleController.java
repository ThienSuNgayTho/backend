package com.englishweb.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.englishweb.backend.entity.Role;
import com.englishweb.backend.repository.RoleRepository;

@RestController
@CrossOrigin
public class RoleController {
	

	@Autowired
	private RoleRepository roleRepository;

	@PostMapping("/role")
	Role newRole(@RequestBody Role newRole) {
		return roleRepository.save(newRole) ;
	}
	
	@GetMapping("/role/list")
	public List<Role> getAllUser() {
		return roleRepository.findAll();
	}

}
