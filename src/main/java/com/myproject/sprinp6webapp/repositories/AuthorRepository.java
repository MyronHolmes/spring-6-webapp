package com.myproject.sprinp6webapp.repositories;

import com.myproject.sprinp6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
