package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.Phone;

public class PhoneDto {

    private Long id;
    private String code;
    private String number;
    private Long parkingId;

    public PhoneDto(Phone phone) {
        this.id = phone.getId();
        this.code = phone.getCode();
        this.number = phone.getNumber();
        this.parkingId = phone.getParking().getId();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }

    public Long getParkingId() {
        return parkingId;
    }
}
