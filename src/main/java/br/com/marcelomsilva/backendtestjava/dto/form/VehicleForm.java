package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.Vehicle;
import br.com.marcelomsilva.backendtestjava.service.ModelService;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleForm {

    @NotNull @NotEmpty
    private String plate;

    @NotNull
    private Long parkingId;

    @NotEmpty
    private Long modelId;

    public VehicleForm(String plate, Long parkingId, Long modelId) {
        this.plate = plate;
        this.parkingId = parkingId;
        this.modelId = modelId;
    }

    public String getPlate() {
        return plate;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public Long getModelId() {
        return modelId;
    }

    public Vehicle convertToEntity(ParkingService parkingService, ModelService modelService) {
        return new Vehicle(plate, parkingService.verifyAndGetById(parkingId), modelService.verifyAndGetById(modelId));
    }
}
