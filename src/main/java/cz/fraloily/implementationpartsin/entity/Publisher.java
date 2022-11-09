package cz.fraloily.implementationpartsin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "publisher")
@Data
public class Publisher implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "publishers", fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy="publisher", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Book> books = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Publisher() {}

    public Publisher(String name) {
        this.name = name;
    }

    public void addAuthor(Author ...authors) {
       this.authors.addAll(List.of(authors));
    }
    public void addBook(Book book) {
        this.books.add(book);
    }

}
