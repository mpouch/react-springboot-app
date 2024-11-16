package com.mpouch.libdive.metadata;

import com.mpouch.libdive.book.Book;
import jakarta.persistence.*;

@Entity
@Table(name = "book_genre")
public class BookGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    protected BookGenre() {}

    public BookGenre(Book book, Genre genre) {
        this.book = book;
        this.genre = genre;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Genre getGenre() {
        return genre;
    }

    // Setters

    public void setBook(Book book) {
        this.book = book;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
