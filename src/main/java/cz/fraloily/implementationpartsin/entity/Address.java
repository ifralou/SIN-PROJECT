package cz.fraloily.implementationpartsin.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Integer number;

    @NotNull
    private String street;

    private String district;

    @NotNull
    private String city;

    @NotNull
    private String country;

    public Address() {}

    public Address(Integer number, String street, String city, String country) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Address(Integer number, String street, String district, String city, String country) {
        this.number = number;
        this.street = street;
        this.district = district;
        this.city = city;
        this.country = country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
