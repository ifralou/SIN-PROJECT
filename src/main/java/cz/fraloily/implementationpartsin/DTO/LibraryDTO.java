package cz.fraloily.implementationpartsin.DTO;

import cz.fraloily.implementationpartsin.entity.Address;

import java.util.Set;

public class LibraryDTO {

    private String name;
    private Address address;
    private Set<BookDTO> books;

    public LibraryDTO(String name, Address address, Set<BookDTO> books) {
        this.name = name;
        this.address = address;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDTO> books) {
        this.books = books;
    }

}
