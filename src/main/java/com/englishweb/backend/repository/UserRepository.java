package com.englishweb.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.englishweb.backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // @Query(value = "SELECT * FROM users u WHERE u.username = :username AND u.password = :password", nativeQuery = true)
    // public User getUserByUsername(String username, String password);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
