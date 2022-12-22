package cz.fraloily.implementationpartsin.controller;

import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.repository.PublisherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/{id}")
    public Author getOne(@PathVariable Long id){
        return null;
    }

}
