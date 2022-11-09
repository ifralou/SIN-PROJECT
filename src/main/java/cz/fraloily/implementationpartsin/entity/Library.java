package cz.fraloily.implementationpartsin.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "library")
@Data public class Library implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Library() {}

}
