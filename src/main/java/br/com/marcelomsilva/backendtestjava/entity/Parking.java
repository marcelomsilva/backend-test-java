package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cnpj;

    private Address address;

    public Parking() {}

    public Parking(String name, String cnpj, Address address) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Address getAddress() {
        return address;
    }
}
