package com.myproject.sprinp6webapp.services;

import com.myproject.sprinp6webapp.domain.Book;
import org.springframework.stereotype.Service;

public interface BookService {
    Iterable<Book> findAll();

}
