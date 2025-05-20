package com.gini.store.internal.domain.repositories;

import com.gini.store.internal.domain.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PartRepository extends JpaRepository<Part, Long> {

    @Query("SELECT p FROM Part p WHERE p.partNumber = :partNumber")
    Optional<Part> findByPartNumber(String partNumber);


}
