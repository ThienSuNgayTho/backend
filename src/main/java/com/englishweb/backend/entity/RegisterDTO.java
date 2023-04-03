package com.englishweb.backend.entity;

import lombok.Data;

@Data
public class RegisterDTO {
    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private int level;
}