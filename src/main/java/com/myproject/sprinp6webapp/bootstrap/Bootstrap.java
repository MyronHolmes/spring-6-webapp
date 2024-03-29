package com.myproject.sprinp6webapp.bootstrap;

import com.myproject.sprinp6webapp.domain.Author;
import com.myproject.sprinp6webapp.domain.Book;
import com.myproject.sprinp6webapp.domain.Publisher;
import com.myproject.sprinp6webapp.repositories.AuthorRepository;
import com.myproject.sprinp6webapp.repositories.BookRepository;
import com.myproject.sprinp6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        noJBESaved.setPublisher(publisherSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noJBESaved);


        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());



        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
