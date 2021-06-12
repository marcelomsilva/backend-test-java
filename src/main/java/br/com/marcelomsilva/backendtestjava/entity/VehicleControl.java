package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "vehicle_control")
public class VehicleControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private Instant entry;
    private Instant departure;
    private Instant duration;
    private Boolean isCancelled;

    public VehicleControl() {}

    public VehicleControl(Vehicle vehicle, Instant entry) {
        this.vehicle = vehicle;
        this.entry = entry;
        this.isCancelled = false;
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

    public void setDeparture(Instant departure) {
        this.departure = departure;
    }

    public Instant getDeparture() {
        return departure;
    }

    public void setDuration(Instant duration) {
        this.duration = duration;
    }

    public Instant getDuration() {
        return duration;
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public Type getVehicleType() {
        return this.vehicle.getModel().getType();
    }

    public Set<Vacancy> getParkingVacancies() {
        return this.vehicle.getParking().getVacancies();
    }
}
