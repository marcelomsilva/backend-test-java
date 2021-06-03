package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "vehicle_control")
public class VehicleControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Vehicle vehicle;
    private Instant entry;
    private Instant departure;

    public VehicleControl() {}

    public VehicleControl(Vehicle vehicle, Instant entry, Instant departure) {
        this.vehicle = vehicle;
        this.entry = entry;
        this.departure = departure;
    }

    public Long getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Instant getEntry() {
        return entry;
    }

    public Instant getDeparture() {
        return departure;
    }
}
