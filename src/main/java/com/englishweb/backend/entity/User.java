package com.englishweb.backend.entity;



import jakarta.persistence.*;


@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Address")
    private String address;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Level")
    private int level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID")
    private Role role;

    // constructors, getters, and setters
}

