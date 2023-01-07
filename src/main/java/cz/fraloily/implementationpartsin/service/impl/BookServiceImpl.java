package cz.fraloily.implementationpartsin.service.impl;

import cz.fraloily.implementationpartsin.entity.Library;
import cz.fraloily.implementationpartsin.exceptions.FailedResponse;
import cz.fraloily.implementationpartsin.repository.BookRepository;
import cz.fraloily.implementationpartsin.repository.LibraryRepository;
import cz.fraloily.implementationpartsin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    public final BookRepository bookRepository;
    public final LibraryRepository libraryRepository;

    public BookServiceImpl(
            @Autowired BookRepository bookRepository,
            @Autowired LibraryRepository libraryRepository
    ) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    public Library addBookToLibrary(Long bookId, Long libraryId) {
        var book = bookRepository.findBookById(bookId)
                .orElseThrow(() -> new FailedResponse(HttpStatus.NOT_FOUND, "Book not found"));
        var library =  libraryRepository.findById(libraryId)
                .orElseThrow(() -> new FailedResponse(HttpStatus.NOT_FOUND, "Library not found"));
        library.addBook(book);
        return libraryRepository.save(library);
    }



}
