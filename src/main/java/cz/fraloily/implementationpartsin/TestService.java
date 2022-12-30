package cz.fraloily.implementationpartsin;

import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.entity.Book;
import cz.fraloily.implementationpartsin.entity.Publisher;
import cz.fraloily.implementationpartsin.repository.AuthorRepository;
import cz.fraloily.implementationpartsin.repository.BookRepository;
import cz.fraloily.implementationpartsin.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class TestService {

    private BookRepository bookRep;
    private AuthorRepository authorRep;
    private PublisherRepository publisherRepository;

    private final Logger log = LoggerFactory.getLogger(TestService.class);


    public TestService(
            @Autowired BookRepository bookRa,
            @Autowired AuthorRepository authorRep,
            @Autowired PublisherRepository publisherRepository
    ) {
        this.bookRep = bookRa;
        this.authorRep = authorRep;
        this.publisherRepository = publisherRepository;
    }

    public TestService testBook() {
        log.info("Loading books for test purposes...");
       bookRep.save(
               new Book(
                       "asdfasdfasdf",
                       "asdfasdasdf",
                       LocalDate.of(1998, 1, 1)
               )
       );

        log.info(bookRep.findAll().toString());
        return this;
    }

    public TestService testPublisher() {
        log.info("Loading publishers for test purposes...");
        var publisher1 = new Publisher("Publisehr1");
        publisherRepository.save(publisher1);

        var publisher2 = new Publisher("Publisehr2");
        publisherRepository.save(publisher2);

        var publisher3 = new Publisher("Publisehr3");
        publisherRepository.save(publisher3);

        log.info(publisherRepository.findAll().toString());
        return this;
    }

    public TestService testAuthor() {
        log.info("Loading authors for test purposes...");
        var author1 = new Author(
                "email@email.com",
                "John",
                "Doe"
        );
        var author2 = new Author(
                "email@email.com",
                "John",
                "Doe"
        );

        log.info(
                "Authors are the same: " + author1.equals(author2)
        );

        authorRep.save(author1);

        log.info(
                authorRep.getAuthorByEmail("email@email.com").toString()
        );

        return this;
    }

    @Transactional
    void persistBooks(Author author, List<Book> books) {
       author.setBooks(books);
    }

    public TestService testAuthorBook() {
        var book = new Book(
                "1234",
                "asdfasdasdf",
                LocalDate.of(1998, 1, 1)
        );
        bookRep.save(book);

        var author = new Author(
                "email@email.com",
                "John",
                "Doe"
        );
        persistBooks(author, List.of(book));
        log.info(author.getBooks().toString());
        authorRep.save(author);

        log.debug(
                authorRep.getAuthorByEmail("email@email.com").toString()
        );
        authorRep.getAuthorByEmail("email@email.com").forEach(
                a -> log.debug(a.getBooks().toString())
        );

        return this;
    }

}
