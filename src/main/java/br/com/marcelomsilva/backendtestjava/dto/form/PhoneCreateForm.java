package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PhoneCreateForm {

    @NotNull @NotEmpty
    private String code;

    @NotNull @NotEmpty
    private String number;

    @Min(0)
    private Long parkingId;

    public PhoneCreateForm(String code, String number, Long parkingId) {
        this.code = code;
        this.number = number;
        this.parkingId = parkingId;
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

    public Phone convertToEntity(ParkingService parkingService) {
        return new Phone(code, number, parkingService.verifyAndGetById(parkingId));
    }
}
