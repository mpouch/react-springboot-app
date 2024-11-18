package com.mpouch.libdive.library;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mpouch.libdive.book.LibraryBook;
import com.mpouch.libdive.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @OneToMany
    @JoinColumn(name = "library_book_id")
    private Set<LibraryBook> libraryBooks = new HashSet<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    protected Library() {}

    public Library(User user, Set<LibraryBook> libraryBooks, LocalDateTime createdAt) {
        this.user = user;
        this.libraryBooks = libraryBooks;
        this.createdAt = createdAt;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Set<LibraryBook> getLibraryBooks() {
        return libraryBooks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters


    public void setUser(User user) {
        this.user = user;
    }

    public void setLibraryBooks(Set<LibraryBook> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
