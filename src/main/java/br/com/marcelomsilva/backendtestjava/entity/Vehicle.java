package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.List;

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

    public String getPlate() {
        return plate;
    }

    public Parking getParking() {
        return parking;
    }

    public Model getModel() {
        return model;
    }

    public Boolean getActive() {
        return isActive;
    }

    public List<VehicleControl> getVehicleControls() {
        return vehicleControls;
    }
}
