package com.myproject.sprinp6webapp.repositories;

import com.myproject.sprinp6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
