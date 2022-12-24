package cz.fraloily.implementationpartsin.service;

import cz.fraloily.implementationpartsin.DTO.PublisherDTO;

public interface PublisherService {
    PublisherDTO addBookToPublisher(long publisherId, Long bookId);
}
