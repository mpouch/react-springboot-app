package com.mpouch.libdive.library;

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

    public Library(User user) {
        this.user = user;
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

}
