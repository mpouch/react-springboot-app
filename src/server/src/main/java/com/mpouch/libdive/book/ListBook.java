package com.mpouch.libdive.book;

import com.mpouch.libdive.library.BookList;
import jakarta.persistence.*;

@Entity
@Table(name = "list_book")
public class ListBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    private BookList bookList;

    protected ListBook() {}

    public ListBook(Book book, BookList bookList) {
        this.book = book;
        this.bookList = bookList;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public BookList getBookList() {
        return bookList;
    }

    // Setters

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }
}
