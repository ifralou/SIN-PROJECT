package cz.fraloily.implementationpartsin.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "library")
public class Library {
    //TODO: Add book relation.

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Library() {}

    public Library(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}