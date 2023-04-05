package com.englishweb.backend.service;

import com.englishweb.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveOrUpdateUser (User user);

    List<User> findAll();
    // public boolean checkUser(String username, String password);

    User findUserById(int userId);

    Boolean checkStatusByUsername(String username);
}
