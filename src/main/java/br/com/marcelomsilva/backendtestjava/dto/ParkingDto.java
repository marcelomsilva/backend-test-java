package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.Address;
import br.com.marcelomsilva.backendtestjava.entity.Parking;

import java.util.Set;
import java.util.stream.Collectors;

public class ParkingDto {

    private Long id;
    private String name;
    private String cnpj;
    private Address address;
    private Set<PhoneDto> phones;
    private Boolean isActive;

    public ParkingDto(Parking parking) {
        this.id = parking.getId();
        this.name = parking.getName();
        this.cnpj = parking.getCnpj();
        this.address = parking.getAddress();
        if(parking.getPhones() != null)
            this.phones = parking.getPhones().stream()
                    .map(p -> new PhoneDto(p))
                    .collect(Collectors.toSet());
        this.isActive = parking.getIsActive();
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

    public Set<PhoneDto> getPhones() {
        return phones;
    }

    public Boolean getActive() {
        return isActive;
    }
}
