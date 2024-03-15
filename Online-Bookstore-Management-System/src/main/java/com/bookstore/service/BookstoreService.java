package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookstoreRepository;

import java.util.List;

@Service
public class BookstoreService {
    @Autowired
    private BookstoreRepository bookstoreRepository;

    public void addBook(Book book) {
        bookstoreRepository.save(book);
    }

    public void removeBook(Long id) {
        bookstoreRepository.deleteById(id);
    }

    public List<Book> searchBooks(String keyword) {
        return bookstoreRepository.findByTitleContainingOrAuthorContaining(keyword, keyword);
    }

    public List<Book> getAllBooks() {
        return bookstoreRepository.findAll();
    }
}
