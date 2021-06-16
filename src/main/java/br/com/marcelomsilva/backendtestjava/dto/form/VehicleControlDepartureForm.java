package br.com.marcelomsilva.backendtestjava.dto.form;

import javax.validation.constraints.Min;
import java.time.Instant;

public class VehicleControlDepartureForm {

    @Min(0)
    private Long vehicleId;

    private Instant departure;

    public VehicleControlDepartureForm(Long vehicleId, Instant departure) {
        this.vehicleId = vehicleId;
        this.setDeparture(departure);
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setDeparture(Instant departure) {
        if(departure == null)
            this.departure = Instant.now();
        else this.departure = departure;
    }

    public Instant getDeparture() {
        return departure;
    }
}
