package com.mpouch.libdive.book;

import com.mpouch.libdive.metadata.Author;
import com.mpouch.libdive.metadata.BookGenre;
import com.mpouch.libdive.metadata.BookType;
import com.mpouch.libdive.metadata.Publishing;
import jakarta.persistence.*;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "release_date", nullable = false)
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publishing_id", nullable = false)
    private Publishing publishing;

    @ManyToOne
    @JoinColumn(name = "book_type_id", nullable = false)
    private BookType bookType;

    @OneToMany(mappedBy = "book")
    private Set<BookGenre> bookGenres = new HashSet<>();

    protected Book() {}

    public Book(String name, String isbn, Year releaseYear, Author author, Publishing publishing, BookType bookType, Set<BookGenre> bookGenres) {
        this.name = name;
        this.isbn = isbn;
        this.releaseYear = releaseYear;
        this.author = author;
        this.publishing = publishing;
        this.bookType = bookType;
        this.bookGenres = bookGenres;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public Author getAuthor() {
        return author;
    }

    public Publishing getPublishing() {
        return publishing;
    }

    public BookType getBookType() {
        return bookType;
    }

    public Set<BookGenre> getBookGenres() {
        return bookGenres;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublishing(Publishing publishing) {
        this.publishing = publishing;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public void setBookGenres(Set<BookGenre> bookGenres) {
        this.bookGenres = bookGenres;
    }
}
