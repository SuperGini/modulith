package com.gini.car.internal.domain.repositories;

import com.gini.car.internal.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {}
