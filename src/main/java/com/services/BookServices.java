package com.services;

import com.model.Book;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServices {
    private List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Initialize with some dummy data
        addBook(new Book(1, "Book 1", "Author 1", 20.0));
        addBook(new Book(2, "Book 2", "Author 2", 25.0));
        addBook(new Book(3, "Book 3", "Author 3", 30.0));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == updatedBook.getId()) {
                books.set(i, updatedBook);
                break;
            }
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}

