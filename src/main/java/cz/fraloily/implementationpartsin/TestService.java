package cz.fraloily.implementationpartsin;

import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.entity.Book;
import cz.fraloily.implementationpartsin.entity.Publisher;
import cz.fraloily.implementationpartsin.repository.AuthorRepository;
import cz.fraloily.implementationpartsin.repository.BookRepository;
import cz.fraloily.implementationpartsin.repository.PublisherRepository;
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
       bookRep.save(
               new Book(
                       "asdfasdfasdf",
                       "asdfasdasdf",
                       LocalDate.of(1998, 1, 1)
               )
       );

        System.out.println(bookRep.findAll());
        return this;
    }

    public TestService testPublisher() {
        var publisher1 = new Publisher("Publisehr1");
        publisherRepository.save(publisher1);

        var publisher2 = new Publisher("Publisehr2");
        publisherRepository.save(publisher2);

        var publisher3 = new Publisher("Publisehr3");
        publisherRepository.save(publisher3);

        System.out.println(publisherRepository.findAll());
        return this;
    }

    public TestService testAuthor() {
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

        System.out.println(
                "Authors are the same: " + author1.equals(author2)
        );

        authorRep.save(author1);

        System.out.println(
                authorRep.getAuthorByEmail("email@email.com")
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
        System.out.println(author.getBooks());
        authorRep.save(author);

        System.out.println(
                authorRep.getAuthorByEmail("email@email.com")
        );
        authorRep.getAuthorByEmail("email@email.com").forEach(
                a -> System.out.println(a.getBooks())
        );

        return this;
    }

}
