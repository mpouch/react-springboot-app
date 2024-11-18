package com.mpouch.libdive.library;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookListService {

    private final BookListRepository bookListRepository;

    public BookListService(BookListRepository bookListRepository) {
        this.bookListRepository = bookListRepository;
    }

    // Get all books lists
    public List<BookList> getAllBookLists() {
        return bookListRepository.findAll();
    }

    // Get book list by ID
    public Optional<BookList> getBookListById(Long id) {
        return bookListRepository.findById(id);
    }

    // Create new book list
    public BookList createBookList(BookList bookList) {
        return bookListRepository.save(bookList);
    }

    // Update book list
    public BookList updateBookList(Long id, BookList updatedBookList) {
        return bookListRepository.findById(id).map(existingBookList -> {
            existingBookList.setName(updatedBookList.getName());
            existingBookList.setListBooks(updatedBookList.getListBooks());
            return bookListRepository.save(existingBookList);
        }).orElse(null);
    }

    // Delete book list
    public boolean deleteBookList(Long id) {
        if (bookListRepository.existsById(id)) {
            bookListRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
