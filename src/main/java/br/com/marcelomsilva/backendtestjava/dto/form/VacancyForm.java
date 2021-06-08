package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.Type;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.repository.TypeRepository;

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

    public Vacancy convertToEntity(TypeRepository typeRepository, ParkingRepository parkingRepository) {
        return new Vacancy(amount, typeRepository.findById(typeId).get(), parkingRepository.findById(parkingId).get());
    }
}
