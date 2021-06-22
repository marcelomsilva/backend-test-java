package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.Type;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;

public class VacancyDto {

    private Long id;
    private Integer amount;
    private Integer amountOccupied;
    private Type type;
    private Long parkingId;
    private String parkingName;

    public VacancyDto(Vacancy vacancy) {
        this.id = vacancy.getId();
        this.amount = vacancy.getAmount();
        this.amountOccupied = vacancy.getAmountOccupied();
        this.type = vacancy.getType();
        this.parkingId = vacancy.getParking().getId();
        this.parkingName = vacancy.getParking().getName();
    }

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getAmountOccupied() {
        return amountOccupied;
    }

    public Type getType() {
        return type;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public String getParkingName() {
        return parkingName;
    }
}
