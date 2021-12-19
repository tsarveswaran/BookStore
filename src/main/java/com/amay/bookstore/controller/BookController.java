package com.amay.bookstore.controller;

import com.amay.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String listAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";

    }

}
