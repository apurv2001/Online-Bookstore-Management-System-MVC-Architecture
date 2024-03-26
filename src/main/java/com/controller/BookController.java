package com.controller;

import com.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.services.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookServices bookService;

    @GetMapping("/")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/?error=invalid_input";
        }
        bookService.addBook(book);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/?error=invalid_input";
        }
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
