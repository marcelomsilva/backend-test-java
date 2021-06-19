package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleControl> vehicleControls;

    private Boolean isActive;

    public Vehicle() {}

    public Vehicle(String plate, Parking parking, Model model) {
        this.plate = plate;
        this.parking = parking;
        this.model = model;
        this.isActive = true;
    }

    public Long getId() {
        return id;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public Parking getParking() {
        return parking;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public List<VehicleControl> getVehicleControls() {
        return vehicleControls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return plate.equals(vehicle.plate) && parking.equals(vehicle.parking) && model.equals(vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate, parking, model);
    }
}
