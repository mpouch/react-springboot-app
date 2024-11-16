package com.mpouch.libdive.library;

import com.mpouch.libdive.book.ListBook;
import com.mpouch.libdive.user.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_list")
public class BookList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "bookList")
    private Set<ListBook> listBooks = new HashSet<>();

    protected BookList() {}

    public BookList(String name, User user, Set<ListBook> listBooks) {
        this.name = name;
        this.user = user;
        this.listBooks = listBooks;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public Set<ListBook> getListBooks() {
        return listBooks;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setListBooks(Set<ListBook> listBooks) {
        this.listBooks = listBooks;
    }
}
