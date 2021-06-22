package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.Phone;

public class PhoneDto {

    private Long id;
    private String code;
    private String number;
    private Long parkingId;
    private String parkingName;

    public PhoneDto(Phone phone) {
        this.id = phone.getId();
        this.code = phone.getCode();
        this.number = phone.getNumber();
        this.parkingId = phone.getParking().getId();
        this.parkingName = phone.getParking().getName();
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

    public String getParkingName() {
        return parkingName;
    }
}
