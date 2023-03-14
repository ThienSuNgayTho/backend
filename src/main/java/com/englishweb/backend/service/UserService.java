package com.englishweb.backend.service;

import com.englishweb.backend.entity.User;

import java.util.List;

public interface UserService {
    void saveOrUpdateUser (User user);
    List<User> findAll();
}
