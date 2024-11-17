package com.mpouch.libdive.library;

import com.mpouch.libdive.book.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Library findByUserId(Long userId);
}
