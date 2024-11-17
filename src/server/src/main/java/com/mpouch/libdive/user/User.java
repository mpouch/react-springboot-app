package com.mpouch.libdive.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mpouch.libdive.library.Library;
import com.mpouch.libdive.security.Role;
import com.mpouch.libdive.security.UserStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private UserStatus userStatus;

    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private Library library;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    protected User() {}

    public User(
            String email,
            String username,
            String password,
            Role role,
            UserStatus userStatus,
            Library library
    ) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.userStatus = userStatus;
        this.library = library;
    }


    // Getters

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Role getRole() {
        return role;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public Library getLibrary() {
        return library;
    }


    // Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', email='" + email + "', role='" + role + "', status='" + userStatus + "'}";
    }

}
