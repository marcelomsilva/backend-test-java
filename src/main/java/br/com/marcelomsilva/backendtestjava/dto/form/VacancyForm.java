package br.com.marcelomsilva.backendtestjava.dto.form;

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
}
