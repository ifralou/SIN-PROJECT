package cz.fraloily.implementationpartsin.controller;

import cz.fraloily.implementationpartsin.service.BookService;
import cz.fraloily.implementationpartsin.service.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookServiceImpl;

    public BookController(BookService bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PutMapping("/{bookId}/publisher")
    void addBookToPublisher(
            @PathVariable Long bookId,
            @RequestParam Long publisherId
    ) {
        bookServiceImpl.addBookToLibrary(bookId, publisherId);
    }
}
