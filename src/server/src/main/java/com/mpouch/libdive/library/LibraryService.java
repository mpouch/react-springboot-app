package com.mpouch.libdive.library;

import com.mpouch.libdive.book.Book;
import com.mpouch.libdive.book.LibraryBook;
import com.mpouch.libdive.book.LibraryBookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final LibraryBookRepository libraryBookRepository;

    public LibraryService(LibraryRepository libraryRepository, LibraryBookRepository libraryBookRepository) {
        this.libraryRepository = libraryRepository;
        this.libraryBookRepository = libraryBookRepository;
    }

    // Add book to library
    public LibraryBook addBookToLibrary(Long userId, Book book) {
        Library library = libraryRepository.findByUserId(userId);
        LibraryBook libraryBook = new LibraryBook(library, book);
        return libraryBookRepository.save(libraryBook);
    }

    // Delete book from library
    public void removeBookFromLibrary(Long userId, Long bookId) {
        Library library = libraryRepository.findByUserId(userId);
        LibraryBook libraryBook = library.getLibraryBooks().stream()
                .filter(lb -> lb.getBook().getId().equals(bookId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        libraryBookRepository.delete(libraryBook);
    }

    // Get all books
    public List<Book> getBooksInLibrary(Long userId) {
        Library library = libraryRepository.findByUserId(userId);
        return library.getLibraryBooks().stream()
                .map(LibraryBook::getBook)
                .toList();
    }

}
