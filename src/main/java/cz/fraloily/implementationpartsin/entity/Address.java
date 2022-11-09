package cz.fraloily.implementationpartsin.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data public class Address implements Serializable {
    @Id
    @GeneratedValue private Long id;
    @NotNull private Integer number;
    @NotNull private String street;
    private String district;
    @NotNull private String city;
    @NotNull private String country;
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

}
