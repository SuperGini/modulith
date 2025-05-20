package com.gini.car.internal.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Constructor {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 10)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "constructor")
    private List<Car> car = new ArrayList<>();

    public Constructor addCar(Car car) {
        this.car.add(car);
        car.setConstructor(this);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Constructor model)) return false;
        return Objects.equals(id, model.id) && Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
