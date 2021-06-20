package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return name.equals(brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
