package com.myproject.sprinp6webapp.services;

import com.myproject.sprinp6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
