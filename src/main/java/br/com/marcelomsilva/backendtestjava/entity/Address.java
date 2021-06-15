package br.com.marcelomsilva.backendtestjava.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("cep")
    private String zipcode;

    @JsonProperty("logradouro")
    private String publicPlace;

    private String number;
    private String complement;

    @JsonProperty("localidade")
    private String city;

    @JsonProperty("uf")
    private String state;

    @JsonProperty("bairro")
    private String neighborhood;

    public Address() { }

    public Address(String zipcode, String publicPlace, String number, String city, String state, String neighborhood, String complement) {
        this.zipcode = zipcode;
        this.publicPlace = publicPlace;
        this.number = number;
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
        this.complement = complement;
    }

    public Long getId() {
        return id;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
