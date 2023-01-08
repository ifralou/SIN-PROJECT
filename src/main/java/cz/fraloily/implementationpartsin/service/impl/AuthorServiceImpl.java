package cz.fraloily.implementationpartsin.service.impl;

import cz.fraloily.implementationpartsin.DTO.AuthorDTO;
import cz.fraloily.implementationpartsin.DTO.mappers.AuthorMapper;
import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.exceptions.FailedResponse;
import cz.fraloily.implementationpartsin.repository.AuthorRepository;
import cz.fraloily.implementationpartsin.repository.PublisherRepository;
import cz.fraloily.implementationpartsin.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    private final Logger log = LoggerFactory.getLogger(AuthorService.class);

    public AuthorServiceImpl(
            @Autowired AuthorRepository repository,
            @Autowired PublisherRepository publisherRepository
    ) {
        this.authorRepository = repository;
        this.publisherRepository = publisherRepository;
    }

    @Cacheable("authors")
    public AuthorDTO getAuthorById(Long id) {
        log.debug("Trying to find author with an id: " + id);
        return toDTO(
                authorRepository
                    .getAuthorById(id)
                    .orElseThrow(() -> new FailedResponse(HttpStatus.NOT_FOUND, "No author with id " + id))
        );
    }


    @Cacheable("authors")
    public AuthorDTO createAuthorIfNotExists(AuthorDTO author) {
        return toDTO(
            authorRepository
                .getAuthorByEmailAndFirstnameAndSurname(
                        author.getEmail(), author.getFirstname(), author.getSurname()
                ).orElseGet(() -> new Author(
                        author.getEmail(),
                        author.getFirstname(),
                        author.getSurname()
                ))
        );
    }

    public AuthorDTO updateAuthorCredentials(Long id, AuthorDTO incoming) {
        var current = authorRepository
                .getAuthorById(id)
                .orElseThrow(() -> new FailedResponse(HttpStatus.NOT_FOUND, "No author exists."));

        current.setEmail(incoming.getEmail());
        current.setFirstname(incoming.getFirstname());
        current.setSurname(incoming.getSurname());

        return toDTO(authorRepository.save(current));
    }

    public AuthorDTO toDTO(Author author) {
        return AuthorMapper.INSTANCE.authorToAuthorDTO(author);
    }


    public void deleteAuthorById(Long id) {
        authorRepository.deleteAuthorById(id);
    }

    public AuthorDTO addPublisher(Long authorId, Long publisherId) {
        var publisherOption = publisherRepository.findById(publisherId);
        if(publisherOption.isEmpty())  {
            throw new FailedResponse(HttpStatus.NOT_FOUND, "No publisher exists.");
        }
        var publisher = publisherOption.get();

        var authorOption = authorRepository.getAuthorById(authorId);
        if(authorOption.isEmpty()) {
            throw new FailedResponse(HttpStatus.NOT_FOUND, "No author with such id: " + authorId);
        }
        var author = authorOption.get();

        publisher.getAuthors().add(author);
        publisherRepository.save(publisher);

        author.getPublishers().add(publisher);

        return toDTO(
                authorRepository.save(author)
        );
    }


}
