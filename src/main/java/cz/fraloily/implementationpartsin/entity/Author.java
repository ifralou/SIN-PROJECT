package cz.fraloily.implementationpartsin.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "author")
@Data public class Author implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Email
    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "firstname")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "surname")
    private String surname;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Publisher> publishers = new HashSet<>();

    public Author() {}
    public Author(String email, String firstName, String surname) {
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Author(String email, String firstName, String surname, Long id) {
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.id = id;
    }

    public void addPublisher(Publisher ...publishers) {
        this.publishers.addAll(List.of(publishers));
    }
    public void addBook(Book book) {
        this.books.add(book);
    }

}
