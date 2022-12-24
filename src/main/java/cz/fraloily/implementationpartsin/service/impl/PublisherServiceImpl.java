package cz.fraloily.implementationpartsin.service.impl;

import cz.fraloily.implementationpartsin.DTO.PublisherDTO;
import cz.fraloily.implementationpartsin.DTO.mappers.PublisherMapper;
import cz.fraloily.implementationpartsin.entity.Publisher;
import cz.fraloily.implementationpartsin.exceptions.FailedResponse;
import cz.fraloily.implementationpartsin.repository.BookRepository;
import cz.fraloily.implementationpartsin.repository.PublisherRepository;
import cz.fraloily.implementationpartsin.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public PublisherServiceImpl(
            @Autowired PublisherRepository publisherRepository,
            @Autowired BookRepository bookRepository
    ) {
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    public PublisherDTO addBookToPublisher(long publisherId, Long bookId) {
        var book = bookRepository.findBookById(bookId)
                .orElseThrow(() -> new FailedResponse(HttpStatus.NOT_FOUND, "NO BOOK FIND."));

        var publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new FailedResponse(HttpStatus.NOT_FOUND, "NO PUBLISHER FOUND."));

        publisher.getBooks().add(book);
        if(book.getPublisher() != null) {
            throw new FailedResponse(HttpStatus.CONFLICT, "Book is already publisher.");
        }
        book.setPublisher(publisher);
        bookRepository.save(book);

        return toDto(
                publisherRepository.save(publisher)
        );
    }

    private PublisherDTO toDto(Publisher p) {
       return PublisherMapper.INSTANCE.publisherToPublisherDTO(p);
    }
}
