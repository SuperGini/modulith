package com.gini.order.internal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PartOrder {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 10)
    private Long id;
    private String partNumber;
    private Integer quantity;

    @ManyToMany
    private List<CustomerOrder> customersOrders = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PartOrder partOrder)) return false;
        return Objects.equals(id, partOrder.id) && Objects.equals(partNumber, partOrder.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partNumber);
    }
}
