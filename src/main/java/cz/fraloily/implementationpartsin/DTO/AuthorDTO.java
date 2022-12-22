package cz.fraloily.implementationpartsin.DTO;

import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.entity.Book;
import cz.fraloily.implementationpartsin.entity.Publisher;
import cz.fraloily.implementationpartsin.exceptions.FailedResponse;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorDTO {

    private String email;

    private String firstname;

    private String surname;

    private List<Book> books;

    private Set<Long> publishers;

    public AuthorDTO() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Set<Long> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers.stream().map(Publisher::getId).collect(Collectors.toSet());
    }

}
