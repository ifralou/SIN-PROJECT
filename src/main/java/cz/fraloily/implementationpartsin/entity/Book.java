package cz.fraloily.implementationpartsin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
@Data public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "isbn")
    @NotNull
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "name")
    private String name;
    @Column(name = "pubDate")
    private LocalDate publishingDate;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    private Publisher publisher;

    public Book() {}

    public Book(String isbn, String name, LocalDate publishingDate) {
        this.isbn = isbn;
        this.name = name;
        this.publishingDate = publishingDate;
    }

    public Book(String isbn, Genre genre, String name, LocalDate publishingDate) {
        this.isbn = isbn;
        this.genre = genre;
        this.name = name;
        this.publishingDate = publishingDate;
    }

    public void addAuthors(List<Author> authors) {
        // Mutability issues
        this.authors.addAll(authors);
    }

}
