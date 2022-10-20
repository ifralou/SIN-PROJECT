package cz.fraloily.implementationpartsin.incomings;

import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.entity.Book;
import cz.fraloily.implementationpartsin.entity.Publisher;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

public class AuthorIn implements Incoming<Author> {

    private String email;

    private String firstname;

    private String surname;

    private List<Book> books;

    private Set<Publisher> publishers;

    public AuthorIn() {}

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

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    @Override
    public Author updateEntity(Author entity) {
        entity.setEmail(email);
        entity.setFirstName(firstname);
        entity.setSurname(surname);
        if(books != null) {
           entity.setBooks(books);
        }
        if(publishers != null) {
           entity.setPublishers(publishers);
        }
        return entity;
    }

    @Override
    public String toString() {
        return "AuthorIn{" +
                "email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", books=" + books +
                ", publishers=" + publishers +
                '}';
    }
}
