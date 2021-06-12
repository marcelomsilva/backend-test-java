package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.Model;
import br.com.marcelomsilva.backendtestjava.entity.Vehicle;

public class VehicleDto {

    private Long id;
    private String plate;
    private ParkingDto parking;
    private Model model;
    private Boolean isActive;

    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.plate = vehicle.getPlate();
        this.parking = new ParkingDto(vehicle.getParking());
        this.model = vehicle.getModel();
        this.isActive = vehicle.getIsActive();
    }

    public Long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public ParkingDto getParking() {
        return parking;
    }

    public Model getModel() {
        return model;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
