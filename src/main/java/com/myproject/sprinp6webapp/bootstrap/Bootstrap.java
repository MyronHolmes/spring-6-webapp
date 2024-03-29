package com.myproject.sprinp6webapp.bootstrap;

import com.myproject.sprinp6webapp.domain.Author;
import com.myproject.sprinp6webapp.domain.Book;
import com.myproject.sprinp6webapp.repositories.AuthorRepository;
import com.myproject.sprinp6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noJBE = new Book();
        noJBE.setTitle("J2EE Development without EJB");
        noJBE.setIsbn("26464920");

        Author rodSaved = authorRepository.save(rod);
        Book noJBESaved = bookRepository.save(noJBE);

        ericSaved.getBook().add(dddSaved);
        rodSaved.getBook().add(noJBESaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
