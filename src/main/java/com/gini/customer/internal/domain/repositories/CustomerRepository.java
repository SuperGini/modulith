package com.gini.customer.internal.domain.repositories;

import com.gini.customer.internal.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
