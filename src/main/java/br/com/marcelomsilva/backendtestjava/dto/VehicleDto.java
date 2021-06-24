package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.Color;
import br.com.marcelomsilva.backendtestjava.entity.Model;
import br.com.marcelomsilva.backendtestjava.entity.Vehicle;

public class VehicleDto {

    private Long id;
    private String plate;
    private Color color;
    private Model model;
    private Boolean isActive;
    private Long parkingId;
    private String parkingName;

    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.plate = vehicle.getPlate();
        this.color = vehicle.getColor();
        this.model = vehicle.getModel();
        this.isActive = vehicle.getIsActive();
        this.parkingId = vehicle.getParking().getId();
        this.parkingName = vehicle.getParking().getName();
    }

    public Long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public Color getColor() {
        return color;
    }

    public Model getModel() {
        return model;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public String getParkingName() {
        return parkingName;
    }
}
