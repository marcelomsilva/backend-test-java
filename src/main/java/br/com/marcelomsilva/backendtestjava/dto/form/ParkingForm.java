package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.Address;
import br.com.marcelomsilva.backendtestjava.entity.Parking;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParkingForm {

    @NotNull @NotEmpty
    private final String name;

    @NotNull @NotEmpty
    private final String cnpj;

    private final String zipCode;
    private final String publicPlace;
    private final String number;
    private final String city;
    private final String state;
    private final String neighbothood;
    private final String complement;


    public ParkingForm(String name, String cnpj, String zipCode, String publicPlace,
                       String number, String city, String state, String neighbothood, String complement) {
        this.name = name;
        this.cnpj = cnpj;
        this.zipCode = zipCode;
        this.publicPlace = publicPlace;
        this.number = number;
        this.city = city;
        this.state = state;
        this.neighbothood = neighbothood;
        this.complement = complement;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getNeighbothood() {
        return neighbothood;
    }

    public String getComplement() {
        return complement;
    }

    public Parking convertToEntity() {
        Address address = new Address(zipCode, publicPlace, number, city, state, neighbothood, complement);
        return new Parking(name, cnpj, address);
    }
}
