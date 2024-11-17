package com.mpouch.libdive.library;

import com.mpouch.libdive.book.Book;
import com.mpouch.libdive.book.LibraryBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // GET
    @GetMapping("/{userId}/books")
    public ResponseEntity<List<Book>> getBooksInLibrary(@PathVariable Long userId) {
        return ResponseEntity.ok(libraryService.getBooksInLibrary(userId));
    }

    // POST
    @PostMapping("/{userId}/add")
    public ResponseEntity<LibraryBook> addBookToLibrary(@PathVariable Long userId, @RequestBody Book book) {
        LibraryBook libraryBook = libraryService.addBookToLibrary(userId, book);
        return ResponseEntity.ok(libraryBook);
    }

    // DELETE
    @DeleteMapping("/{userId}/remove/{bookId}")
    public ResponseEntity<Void> removeBookFromLibrary(@PathVariable Long userId, @PathVariable Long bookId) {
        libraryService.removeBookFromLibrary(userId, bookId);
        return ResponseEntity.noContent().build();
    }
}
