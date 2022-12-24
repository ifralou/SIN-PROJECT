package cz.fraloily.implementationpartsin.controller;

import cz.fraloily.implementationpartsin.DTO.PublisherDTO;
import cz.fraloily.implementationpartsin.service.PublisherService;
import cz.fraloily.implementationpartsin.service.impl.PublisherServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherServiceImpl;

    public PublisherController(PublisherService publisherServiceImpl) {
        this.publisherServiceImpl = publisherServiceImpl;
    }

    @PutMapping("/{id}/newbook")
    public PublisherDTO releaseBook(
            @PathVariable Long id,
            @RequestParam Long bookId
    ) {
        return publisherServiceImpl.addBookToPublisher(id, bookId);
    }


}
