package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.Vehicle;
import br.com.marcelomsilva.backendtestjava.service.ColorService;
import br.com.marcelomsilva.backendtestjava.service.ModelService;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VehicleForm {

    @NotNull @NotEmpty
    private String plate;

    @Min(0)
    private Long colorId;

    @Min(0)
    private Long parkingId;

    @Min(0)
    private Long modelId;

    public VehicleForm(String plate, Long colorId, Long parkingId, Long modelId) {
        this.plate = plate;
        this.colorId = colorId;
        this.parkingId = parkingId;
        this.modelId = modelId;
    }

    public String getPlate() {
        return plate;
    }

    public Long getColorId() {
        return colorId;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public Long getModelId() {
        return modelId;
    }

    public Vehicle convertToEntity(ColorService colorService, ParkingService parkingService, ModelService modelService) {
        return new Vehicle(plate, colorService.verifyAndGetById(colorId),parkingService.verifyAndGetById(parkingId), modelService.verifyAndGetById(modelId));
    }
}
