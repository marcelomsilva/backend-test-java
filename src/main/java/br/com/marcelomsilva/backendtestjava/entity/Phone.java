package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String number;
    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;

    public Phone() {}

    public Phone(String code, String number) {
        this.code = code;
        this.number = number;
    }
    public Phone(String code, String number, Parking parking) {
        this.code = code;
        this.number = number;
        this.parking = parking;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
