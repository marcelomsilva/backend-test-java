package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;

import java.time.Instant;

public class VehicleControlDto {

    private VehicleDto vehicle;
    private Instant entry;
    private Instant departure;


    public VehicleControlDto(VehicleControl vehicleControl) {
        this.vehicle = new VehicleDto(vehicleControl.getVehicle());
        this.entry = vehicleControl.getEntry();
        this.departure = vehicleControl.getDeparture();
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public Instant getEntry() {
        return entry;
    }

    public Instant getDeparture() {
        return departure;
    }
}
