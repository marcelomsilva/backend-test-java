package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.Objects;

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

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNumber(String number) {
        this.number = number;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return code.equals(phone.code) && number.equals(phone.number) && parking.equals(phone.parking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number, parking);
    }
}
