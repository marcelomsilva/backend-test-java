package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.service.VehicleService;

import java.time.Instant;

public class VehicleControlEntryForm {

    private Long vehicleId;
    private Instant entry;

    public VehicleControlEntryForm(Long vehicleId, Instant entry) {
        this.vehicleId = vehicleId;
        this.entry = entry;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public Instant getEntry() {
        return entry;
    }

    public VehicleControl convertToEntity(VehicleService vehicleService) {
        return new VehicleControl(vehicleService.verifyAndGetById(vehicleId), entry);
    }
}
