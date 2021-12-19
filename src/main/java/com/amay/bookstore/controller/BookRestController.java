package com.amay.bookstore.controller;

import com.amay.bookstore.model.Book;
import com.amay.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BookRestController {
    @Autowired
    BookService bookService;

    @GetMapping("/rest/books")
    public List<Book> listAllBooksUsingRest() {
        return bookService.getAllBooks();
    }

}
