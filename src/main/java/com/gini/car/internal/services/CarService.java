package com.gini.car.internal.services;

import com.gini.car.external.api.generated.model.CarRequest;
import com.gini.car.internal.domain.entities.Car;
import com.gini.car.internal.domain.repositories.CarRepository;
import com.gini.car.internal.domain.repositories.ConstructorRepository;
import com.gini.car.internal.mappers.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ConstructorRepository constructorRepository;

    private final CarMapper carMapper;

    @Transactional
    public void save(CarRequest carRequest) {
        var constructorName = carRequest.getConstructor().getName();

       var constructor =  constructorRepository.findByName(constructorName)
               .orElseThrow(() -> new RuntimeException(" Car constructor not found"));

       var car = Car.builder()
               .vin(carRequest.getVin())
               .name(carRequest.getName())
               .constructor(constructor)
               .build();

        carRepository.save(car);
    }

}
