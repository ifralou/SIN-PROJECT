package cz.fraloily.implementationpartsin.DTO;

import cz.fraloily.implementationpartsin.entity.Address;
import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.entity.Book;

import java.util.Set;
import java.util.stream.Collectors;

public class PublisherDTO {
    private String name;
    private Set<Long> author;
    private Set<Long> books;
    private Address address;

    public PublisherDTO() {}

    public PublisherDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author.stream().map(Author::getId).collect(Collectors.toSet());
    }

    public Set<Long> getBooks() {
        return books;
    }

    public void setBooks(Set<Author> books) {
        this.books = books.stream().map(Author::getId).collect(Collectors.toSet());
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
