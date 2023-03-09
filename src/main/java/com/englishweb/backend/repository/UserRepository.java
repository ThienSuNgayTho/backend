package com.englishweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.englishweb.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
