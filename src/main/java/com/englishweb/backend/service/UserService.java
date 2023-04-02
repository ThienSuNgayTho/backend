package com.englishweb.backend.service;

import com.englishweb.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveOrUpdateUser (User user);

    List<User> findAll();

    User findUserById(int userId);
    // public boolean checkUser(String username, String password);

    User addUser(User user);

    User getUserByUsername(String username);

    User getUserByUsernameAndPassword(String username, String password);

    User getUserById(int id);

    User updateUser(User user);

    void deleteUser(int id);

    User getUserByEmail(String email);

   
}
