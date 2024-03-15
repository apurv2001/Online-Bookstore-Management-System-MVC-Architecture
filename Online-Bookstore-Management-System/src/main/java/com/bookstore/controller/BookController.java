package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookstore.model.Book;
import com.bookstore.service.BookstoreService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookstoreService bookstoreService;

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookstoreService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookstoreService.removeBook(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookstoreService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookstoreService.getBookById(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return bookstoreService.searchBooks(keyword);
    }
}
