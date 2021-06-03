package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany
    private Set<Phone> phones;

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

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }
}
