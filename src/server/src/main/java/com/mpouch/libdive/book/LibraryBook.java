package com.mpouch.libdive.book;

import com.mpouch.libdive.library.Library;
import jakarta.persistence.*;

@Entity
@Table(name = "library_book")
public class LibraryBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    protected LibraryBook() {}

    public LibraryBook(Library library, Book book) {
        this.library = library;
        this.book = book;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public Library getLibrary() {
        return library;
    }

    public Book getBook() {
        return book;
    }

    // Setters

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
