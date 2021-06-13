package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;

public class PhoneCreateForm {

    private String code;
    private String number;
    private Long parkingId;

    public PhoneCreateForm(String code, String number, Long parkingId) {
        this.code = code;
        this.number = number;
        this.parkingId = parkingId;
    }

    public Phone convertToEntity(ParkingService parkingService) {
        return new Phone(code, number, parkingService.verifyAndGetById(parkingId));
    }
}
