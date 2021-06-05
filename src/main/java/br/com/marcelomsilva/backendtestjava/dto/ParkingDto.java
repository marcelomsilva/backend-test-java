package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.Address;
import br.com.marcelomsilva.backendtestjava.entity.Parking;

public class ParkingDto {

    private Long id;
    private String name;
    private String cnpj;
    private Address address;

    public ParkingDto(Parking parking) {
        this.id = parking.getId();
        this.name = parking.getName();
        this.cnpj = parking.getCnpj();
        this.address = parking.getAddress();
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
