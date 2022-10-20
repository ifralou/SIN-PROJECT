package cz.fraloily.implementationpartsin.service;

import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.incomings.AuthorIn;
import cz.fraloily.implementationpartsin.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/author")
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(
            @Autowired AuthorRepository authorRepository
    ) {
        this.authorRepository = authorRepository;
    }

    @GetMapping(value = "/{id}")
    Author getOne(@PathVariable Long id) {
        return authorRepository
                .getAuthorById(id)
                .orElseThrow(() -> new RuntimeException("No such author"));
    }

    @PostMapping
    @Transactional
    public Author postOne(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/{id}")
    @Transactional
    public Author putOne(@PathVariable Long id, @RequestBody AuthorIn incoming) {
        var current = authorRepository
                .getAuthorById(id)
                .orElseThrow(() -> new RuntimeException("No author found"));
        return authorRepository.save(incoming.updateEntity(current));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteOne(@PathVariable Long id) {
        authorRepository.deleteAuthorById(id);
    }
}
