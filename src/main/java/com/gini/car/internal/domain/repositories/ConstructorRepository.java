package com.gini.car.internal.domain.repositories;

import com.gini.car.internal.domain.entities.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Transactional(propagation = MANDATORY)
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    @Query("SELECT c FROM Constructor c WHERE c.name = :name")
    Optional<Constructor> findByName(String name);

}
