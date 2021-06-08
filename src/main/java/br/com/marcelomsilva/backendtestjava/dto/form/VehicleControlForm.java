package br.com.marcelomsilva.backendtestjava.dto.form;

import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.repository.VehicleRepository;

import java.time.Instant;

public class VehicleControlForm {

    private Long vehicleId;
    private Instant entry;

    public VehicleControlForm(Long vehicleId, Instant entry) {
        this.vehicleId = vehicleId;
        this.entry = entry;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public Instant getEntry() {
        return entry;
    }

    public VehicleControl convertToEntity(VehicleRepository vehicleRepository) {
        return new VehicleControl(vehicleRepository.findById(vehicleId).get(), entry);
    }
}
