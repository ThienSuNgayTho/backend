package com.englishweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.englishweb.backend.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long > {
    Optional<Role> findByRoleName(String rolename);
}
