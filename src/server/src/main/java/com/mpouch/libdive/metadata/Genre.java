package com.mpouch.libdive.metadata;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<BookGenre> bookGenres = new HashSet<>();

    protected Genre() {}

    public Genre(String name, Set<BookGenre> bookGenres) {
        this.name = name;
        this.bookGenres = bookGenres;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<BookGenre> getBookGenres() {
        return bookGenres;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setBookGenres(Set<BookGenre> bookGenres) {
        this.bookGenres = bookGenres;
    }
}
