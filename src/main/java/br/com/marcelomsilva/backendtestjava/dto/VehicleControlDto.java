package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;

import java.time.Duration;
import java.time.Instant;

public class VehicleControlDto {

    private Long id;
    private VehicleDto vehicle;
    private Instant entry;
    private Instant departure;
    private Duration duration;


    public VehicleControlDto(VehicleControl vehicleControl) {
        this.id = vehicleControl.getId();
        this.vehicle = new VehicleDto(vehicleControl.getVehicle());
        this.entry = vehicleControl.getEntry();
        this.departure = vehicleControl.getDeparture();
        this.duration = vehicleControl.getDuration();
    }

    public Long getId() {
        return id;
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

    public Duration getDuration() {
        return duration;
    }
}
