package com.gini.customer.internal.domain.repositories;

import com.gini.customer.internal.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.name = :id")
    Optional<Customer> findById(String id);

}
