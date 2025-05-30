package com.gini.order.internal.domain.entities;

import jakarta.persistence.CascadeType;
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
public class CustomerOrder {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 10)
    private Long id;
    private Long customerId;
    private String vin;

    @OneToMany(mappedBy = "customersOrders", cascade = CascadeType.PERSIST)
    private List<PartOrder> parts = new ArrayList<>();


    public void addPart(PartOrder partOrder) {
        parts.add(partOrder);
        partOrder.setCustomersOrders(this);
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CustomerOrder that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(customerId, that.customerId) && Objects.equals(vin, that.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, vin);
    }
}
