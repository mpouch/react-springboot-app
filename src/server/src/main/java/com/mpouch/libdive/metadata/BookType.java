package com.mpouch.libdive.metadata;

import jakarta.persistence.*;

@Entity
@Table(name = "book_type")
public class BookType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    protected BookType() {}

    public BookType(String name) {
        this.name = name;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }
}
