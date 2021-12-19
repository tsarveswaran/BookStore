package com.amay.bookstore.controller;

import com.amay.bookstore.model.Book;
import com.amay.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String listAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";

    }

    @GetMapping("/books/new")
    public String createBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "create_book";
    }


    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "edit_book";
    }

    @PostMapping("/books/{id}")
    public String listBookById(@PathVariable Long id, @ModelAttribute("books") Book book, Model model) {
        Book existingBook = bookService.getBookById(id);
        existingBook.setId(id);
        existingBook.setIsbn(book.getIsbn());
        existingBook.setTitle(book.getTitle());
        existingBook.setPrice(book.getPrice());
        existingBook.setAuthor(book.getAuthor());
        bookService.updateBook(existingBook);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }


}
