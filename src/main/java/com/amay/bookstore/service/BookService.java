package com.amay.bookstore.service;


import com.amay.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBookById(Long id);
}
