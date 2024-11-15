package com.mpouch.libdive.library;

import com.mpouch.libdive.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "library_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    // Create library book FK here

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Library() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
