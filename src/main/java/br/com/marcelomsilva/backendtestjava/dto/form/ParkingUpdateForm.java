package br.com.marcelomsilva.backendtestjava.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParkingUpdateForm {

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


    public ParkingUpdateForm(String name, String cnpj, String zipCode, String publicPlace, String city, String state, String neighborhood, String number, String complement) {
        this.name = name;
        this.cnpj = cnpj;
        this.zipCode = zipCode;
        this.publicPlace = publicPlace;
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
        this.number = number;
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

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getComplement() {
        return complement;
    }
}
