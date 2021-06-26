package br.com.marcelomsilva.backendtestjava.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    private String name;

    @ManyToMany(mappedBy = "role")
    private Set<Parking> parkings;

    public Role() {}

    @Override
    public String getAuthority() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
