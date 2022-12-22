package cz.fraloily.implementationpartsin.controller;

import cz.fraloily.implementationpartsin.DTO.mappers.AuthorMapper;
import cz.fraloily.implementationpartsin.exceptions.FailedResponse;
import cz.fraloily.implementationpartsin.DTO.AuthorDTO;
import cz.fraloily.implementationpartsin.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(
            @Autowired AuthorService service
    ) {
        this.service = service;
    }



    @GetMapping(value = "/{id}")
    AuthorDTO getOne(@PathVariable Long id) { return service.getAuthorById(id); }

    @PostMapping
    @Transactional
    public AuthorDTO postOne(@RequestBody AuthorDTO author) { return service.createAuthorIfNotExists(author); }

    @PostMapping("/pub")
    public AuthorDTO addAuthorToPublisher(
            @RequestParam(required = false) Long authorId,
            @RequestParam(required = false) Long pubId
    ) {
        return service.addPublisher(authorId, pubId);
    }

    @PutMapping("/{id}")
    public AuthorDTO putOne(@PathVariable Long id, @RequestBody AuthorDTO incoming) { return service.updateAuthorCredentials(id, incoming); }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        service.deleteAuthorById(id);
    }

}
