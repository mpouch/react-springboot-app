package com.mpouch.libdive.metadata;

import jakarta.persistence.*;

@Entity
@Table(name = "book_genre")
public class BookGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    protected BookGenre () {}

    public BookGenre(String name) {
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
