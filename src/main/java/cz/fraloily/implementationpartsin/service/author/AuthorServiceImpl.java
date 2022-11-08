package cz.fraloily.implementationpartsin.service.author;

import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.exceptions.FailedResponse;
import cz.fraloily.implementationpartsin.incomings.AuthorDTO;
import cz.fraloily.implementationpartsin.repository.AuthorRepository;
import cz.fraloily.implementationpartsin.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Author addPublisherToAuthor(Long authorId, Long publisherId) {
        var author = authorRepository.getAuthorById(authorId)
                .orElseThrow(() -> new FailedResponse(HttpStatus.BAD_REQUEST, "No such author with id: " + authorId));

        var publisher = publisherRepository.getPublisherById(publisherId)
                .orElseThrow(() -> new FailedResponse(HttpStatus.BAD_REQUEST, " No such publisher with id " + publisherId));

        publisher.addAuthor(author);
        publisherRepository.save(publisher);

        author.addPublisher(publisher);
        authorRepository.save(author);

        return authorRepository.getAuthorById(authorId).get();
    }


}
