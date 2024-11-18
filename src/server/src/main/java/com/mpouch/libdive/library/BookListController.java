package com.mpouch.libdive.library;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booklists")
public class BookListController {

    private final BookListService bookListService;

    public BookListController(BookListService bookListService) {
        this.bookListService = bookListService;
    }

    // GET
    @GetMapping
    public List<BookList> getAllBookLists() {
        return bookListService.getAllBookLists();
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookList> getBookListById(@PathVariable Long id) {
        return bookListService.getBookListById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    public ResponseEntity<BookList> createBookList(@RequestBody BookList bookList) {
        BookList createdBookList = bookListService.createBookList(bookList);
        return ResponseEntity.ok(createdBookList);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<BookList> updateBookList(@PathVariable Long id, @RequestBody BookList updatedBookList) {
        BookList bookList = bookListService.updateBookList(id, updatedBookList);

        if (bookList != null) {
            return ResponseEntity.ok(bookList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookList(@PathVariable Long id) {
        if (bookListService.deleteBookList(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
