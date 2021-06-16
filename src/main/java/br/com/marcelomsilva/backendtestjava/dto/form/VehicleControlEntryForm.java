package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.service.VehicleService;

import javax.validation.constraints.Min;
import java.time.Instant;

public class VehicleControlEntryForm {

    @Min(0)
    private Long vehicleId;

    private Instant entry;

    public VehicleControlEntryForm(Long vehicleId, Instant entry) {
        this.vehicleId = vehicleId;
        this.setEntry(entry);
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setEntry(Instant entry) {
        if(entry == null)
            this.entry = Instant.now();
        else this.entry = entry;
    }

    public Instant getEntry() {
        return entry;
    }

    public VehicleControl convertToEntity(VehicleService vehicleService) {
        return new VehicleControl(vehicleService.verifyAndGetById(vehicleId), entry);
    }
}
