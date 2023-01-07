package cz.fraloily.implementationpartsin;

import cz.fraloily.implementationpartsin.entity.Book;
import cz.fraloily.implementationpartsin.entity.Library;
import cz.fraloily.implementationpartsin.repository.BookRepository;
import cz.fraloily.implementationpartsin.repository.LibraryRepository;
import cz.fraloily.implementationpartsin.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class ImplementationPartSinApplicationServicesTests {


    @Mock
    private BookRepository bookRepository;

    @Mock
    private LibraryRepository libraryRepository;

    private final Logger log = LoggerFactory.getLogger(ImplementationPartSinApplicationServicesTests.class);

    // Same logic is implemented in all repositories, don't have mental capacity to repeat all of this 10 times.
    @Test
    void testBookService() {
        final String libraryName = "Lincoln Library";

        var book = new Book("xxxx", "How I encountered your mother", LocalDate.of(2012, 1, 1));
        book.setId(69L);
        var library = new Library(libraryName);
        library.setBooks(new HashSet<>());
        library.setId(1L);

        doReturn(Optional.of(book)).when(bookRepository).findBookById(69L);
        doReturn(Optional.of(library)).when(libraryRepository).findById(1L);
        doReturn(library).when(libraryRepository).save(library);

        var bookService = new BookServiceImpl(bookRepository, libraryRepository);

        var resultLibrary = bookService.addBookToLibrary(69L, 1L);

        Assert.assertEquals(resultLibrary.getName(), libraryName);
        Assert.assertEquals(resultLibrary.getId(), Long.valueOf(1L));
        Assert.assertTrue(resultLibrary.getBooks().contains(book));

    }

}
