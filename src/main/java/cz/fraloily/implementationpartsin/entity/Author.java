package cz.fraloily.implementationpartsin.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "author")
public class Author {

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
    private String firstname;

    @NotNull
    @NotBlank
    @Column(name = "surname")
    private String surname;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Publisher> publishers = new HashSet<>();

    public Author() {}
    public Author(String email, String firstname, String surname) {
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
    }

    public Author(String email, String firstname, String surname, Long id) {
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getId(), author.getId()) && Objects.equals(getEmail(), author.getEmail()) && Objects.equals(getFirstname(), author.getFirstname()) && Objects.equals(getSurname(), author.getSurname()) && Objects.equals(getBooks(), author.getBooks()) && Objects.equals(getPublishers(), author.getPublishers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getFirstname(), getSurname(), getBooks(), getPublishers());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", books=" + books +
                ", publishers=" + publishers.stream().map(Publisher::getId)+
                '}';
    }
}
