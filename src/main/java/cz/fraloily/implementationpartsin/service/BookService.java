package cz.fraloily.implementationpartsin.service;

import cz.fraloily.implementationpartsin.entity.Library;

public interface BookService {
    public Library addBookToLibrary(Long bookId, Long libraryId);
}
