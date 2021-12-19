package com.amay.bookstore.repository;

import com.amay.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository  extends JpaRepository<Book, Long> {
}
