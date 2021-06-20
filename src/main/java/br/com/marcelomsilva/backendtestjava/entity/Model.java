package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Model() {}

    public Model(String name, Brand brand, Type type) {
        this.name = name;
        this.brand = brand;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return name.equals(model.name) && brand.equals(model.brand) && type.equals(model.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, type);
    }
}
