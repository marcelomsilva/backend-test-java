package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;
    private Parking parking;
    private Model model;

    public Vehicle() {}

    public Vehicle(String plate, Parking parking, Model model) {
        this.plate = plate;
        this.parking = parking;
        this.model = model;
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
}
