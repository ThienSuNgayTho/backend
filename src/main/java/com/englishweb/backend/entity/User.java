package com.englishweb.backend.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
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

  @Column(name = "Status")
  private boolean status;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "UserId"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "RoleId"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password, String fullName,
      String address, String phoneNumber, int level, boolean status) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.fullName = fullName;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.level = level;
    this.status = status;
  }

  
    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
