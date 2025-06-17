package com.gini.car.internal.domain.repositories;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

import com.gini.car.internal.domain.entities.Constructor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = MANDATORY)
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    @Query("SELECT c FROM Constructor c WHERE c.name = :name")
    Optional<Constructor> findByName(String name);
}
