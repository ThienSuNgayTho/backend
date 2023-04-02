package com.englishweb.backend.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.englishweb.backend.entity.User;
import com.englishweb.backend.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Override
        @Transactional
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "User not found with username: " + username));

                return UserDetailsImpl.build(user);
        }
        // Set<GrantedAuthority> authorities = user
        // .getRoles()
        // .stream()
        // .map((role) -> new
        // SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());

        // return new
        // org.springframework.security.core.userdetails.User(user.getEmail(),
        // user.getPassword(),
        // authorities);

}
