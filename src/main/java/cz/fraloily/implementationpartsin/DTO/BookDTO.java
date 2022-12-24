package cz.fraloily.implementationpartsin.DTO;

import java.time.LocalDate;
import java.util.Set;

public class BookDTO {
    private String isbn;
    private String name;
    private LocalDate publishingDate;
    private Set<Long> authors;
    private PublisherDTO publisher;

    public BookDTO(String isbn, String name, LocalDate publishingDate) {
        this.isbn = isbn;
        this.name = name;
        this.publishingDate = publishingDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Set<Long> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Long> authors) {
        this.authors = authors;
    }

    public PublisherDTO getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDTO publisher) {
        this.publisher = publisher;
    }
}
