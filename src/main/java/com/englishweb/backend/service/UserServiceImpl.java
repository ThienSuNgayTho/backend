package com.englishweb.backend.service;

import com.englishweb.backend.entity.User;
import com.englishweb.backend.repository.RoleRepository;
import com.englishweb.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveOrUpdateUser(User user) {
         userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
      return userRepository.findAll();
    }

    @Override
    public User findUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
    }
}
