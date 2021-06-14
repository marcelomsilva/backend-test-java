package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;
    private Integer amountOccupied;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;

    public Vacancy() {}

    public Vacancy(Integer amount, Type type, Parking parking) {
        this.amount = amount;
        this.amountOccupied = 0;
        this.type = type;
        this.parking = parking;
    }

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }

    public Parking getParking() {
        return parking;
    }

    public void incrementAmountOccupied() {
        this.amountOccupied++;
    }

    public Integer getAmountOccupied() {
        return amountOccupied;
    }

    public void decrementAmountOccupied() {
        this.amountOccupied--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return type.equals(vacancy.type) && parking.equals(vacancy.parking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, parking);
    }
}
