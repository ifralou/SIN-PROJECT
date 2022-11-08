package cz.fraloily.implementationpartsin.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    //TODO: Add library relation.

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "isbn")
    @NotNull
    private String isbn;

    @Column(name = "name")
    private String name;
    @Column(name = "pubDate")
    private LocalDate publishingDate;

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    private Publisher publisher;

    public Book() {}

    public Book(String isbn, String name, LocalDate publishingDate) {
        this.isbn = isbn;
        this.name = name;
        this.publishingDate = publishingDate;
    }

    public Book(String isbn, String name, LocalDate publishingDate, Long id) {
        this.isbn = isbn;
        this.name = name;
        this.publishingDate = publishingDate;
        this.id = id;
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

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", publishingDate=" + publishingDate +
                '}';
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
