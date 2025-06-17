package com.gini.car.internal.mappers;

import com.gini.car.internal.domain.entities.Car;
import com.gini.car.internal.domain.entities.Constructor;
import com.gini.car_module_openapi.model.CarRequest;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<CarRequest, Car> {

    @Override
    public Car mapFrom(CarRequest carRequest) {
        var constructor = Constructor.builder().name(carRequest.getConstructor().getName()).build();

        return Car.builder()
                .vin(carRequest.getVin())
                .name(carRequest.getName())
                .constructor(constructor)
                .build();
    }
}
