package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.Address;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParkingForm {

    @NotNull @NotEmpty
    private final String name;

    @NotNull @NotEmpty
    private final String cnpj;


    @NotNull @NotEmpty
    private final String zipCode;

    @NotNull @NotEmpty
    private final String publicPlace;

    @NotNull @NotEmpty
    private final String city;

    @NotNull @NotEmpty
    private final String state;

    @NotNull @NotEmpty
    private final String neighborhood;

    private final String number;
    private final String complement;

    private final String phoneCode;
    private final String phoneNumber;


    public ParkingForm(String name, String cnpj, String zipCode, String publicPlace,
                       String number, String city, String state, String neighborhood,
                       String complement, String phoneCode, String phoneNumber) {
        this.name = name;
        this.cnpj = cnpj;
        this.zipCode = zipCode;
        this.publicPlace = publicPlace;
        this.number = number;
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
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

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Parking convertToEntity(Address address,Phone phone) {
        return new Parking(name, cnpj, address, phone);
    }
}
