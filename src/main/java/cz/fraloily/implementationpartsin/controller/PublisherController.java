package cz.fraloily.implementationpartsin.controller;

import cz.fraloily.implementationpartsin.DTO.PublisherDTO;
import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.repository.PublisherRepository;
import cz.fraloily.implementationpartsin.service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PutMapping("/{id}/newbook")
    public PublisherDTO releaseBook(
            @PathVariable Long id,
            @RequestParam Long bookId
    ) {
        return publisherService.addBookToPublisher(id, bookId);
    }


}
