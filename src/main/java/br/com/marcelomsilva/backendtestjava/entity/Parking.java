package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "parking", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Phone> phones = new HashSet<Phone>();

    @OneToMany(mappedBy = "parking")
    private Set<Vacancy> vacancies = new HashSet<Vacancy>();


    @OneToMany(mappedBy = "parking")
    private Set<Vehicle> vehicles;

    private Boolean isActive;

    public Parking() {}

    public Parking(String name, String cnpj, Address address, Phone phone) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.addPhone(phone);
        this.isActive = true;
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

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public void addVacancy(Vacancy vacancy) {
        this.vacancies.add(vacancy);
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
