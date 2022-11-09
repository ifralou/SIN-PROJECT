package cz.fraloily.implementationpartsin.controller;

import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.exceptions.FailedResponse;
import cz.fraloily.implementationpartsin.incomings.AuthorDTO;
import cz.fraloily.implementationpartsin.repository.AuthorRepository;
import cz.fraloily.implementationpartsin.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    private final AuthorService authorService;

    public AuthorController(
            @Autowired AuthorRepository authorRepository,
            @Autowired AuthorService authorService
    ) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @GetMapping(value = "/{id}")
    Author getOne(@PathVariable Long id) {
        return authorRepository
                .getAuthorById(id)
                .orElseThrow(() -> new FailedResponse(HttpStatus.NOT_FOUND, "No author with id " + id));
    }

    @PostMapping
    @Transactional
    public Author postOne(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/{id}")
    @Transactional
    public Author putOne(@PathVariable Long id, @RequestBody AuthorDTO incoming) {
        var current = authorRepository
                .getAuthorById(id)
                .orElseThrow(() -> new FailedResponse( HttpStatus.NOT_FOUND, "No author with id " + id));
        return authorRepository.save(incoming.updateEntity(current));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteOne(@PathVariable Long id) {
        authorRepository.deleteAuthorById(id);
    }

    @PutMapping("/publisher")
    public Author addPublishersToAuthor(
            @RequestParam Long author,
            @RequestParam Long pub
    ) {
        return authorService.addPublisherToAuthor(author, pub);
    }

}
