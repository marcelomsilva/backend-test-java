package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;
    /*
    private Type type;
    private Parking parking;

     */

    public Vacancy(Integer amount, Type type, Parking parking) {
        this.amount = amount;
        /*
        this.type = type;
        this.parking = parking;

         */
    }

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    /*
    public Type getType() {
        return type;
    }

    public Parking getParking() {
        return parking;
    }

     */
}
