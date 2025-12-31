package com.wallet.user_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public enum Role {
        USER,
        ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}

    public User(String username, Double balance, Role role) {
        this.username = username;
        this.balance = balance;
        this.role = role;
    }

    public Long getId() { return id; }

    public String getUsername() { return username; }

    public Double getBalance() { return balance; }

    public Role getRole() { return role; }

    public void setUsername(String username) { this.username = username; }

    public void setBalance(Double balance) { this.balance = balance; }

    public void setRole(Role role) { this.role = role; }
}
