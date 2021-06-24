package br.com.marcelomsilva.backendtestjava.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Color() {}

    public Color(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return name.equals(color.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
