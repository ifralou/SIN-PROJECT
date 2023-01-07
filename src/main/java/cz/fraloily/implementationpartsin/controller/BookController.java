package cz.fraloily.implementationpartsin.controller;

import cz.fraloily.implementationpartsin.entity.Library;
import cz.fraloily.implementationpartsin.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookServiceImpl;

    public BookController(BookService bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PutMapping("/{bookId}/publisher")
    Library addBookToPublisher(
            @PathVariable Long bookId,
            @RequestParam Long publisherId
    ) {
        return bookServiceImpl.addBookToLibrary(bookId, publisherId);
    }

}
