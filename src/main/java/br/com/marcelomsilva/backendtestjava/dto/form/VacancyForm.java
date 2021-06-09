package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import br.com.marcelomsilva.backendtestjava.service.TypeService;

public class VacancyForm {

    private Integer amount;
    private Long typeId;
    private Long parkingId;

    public VacancyForm(Integer amount, Long typeId, Long parkingId) {
        this.amount = amount;
        this.typeId = typeId;
        this.parkingId = parkingId;
    }

    public Integer getAmount() {
        return amount;
    }

    public Long getTypeId() {
        return typeId;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public Vacancy convertToEntity(TypeService typeService, ParkingService parkingService) {
        return new Vacancy(amount, typeService.verifyAndGetById(typeId), parkingService.verifyAndGetById(parkingId));
    }
}
