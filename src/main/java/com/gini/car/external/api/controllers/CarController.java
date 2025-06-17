package com.gini.car.external.api.controllers;

import com.gini.car.internal.services.CarService;
import com.gini.car.internal.services.ConstructorService;
import com.gini.car_module_openapi.api.CarApi;
import com.gini.car_module_openapi.model.CarRequest;
import com.gini.car_module_openapi.model.ConstructorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController implements CarApi {

    private final CarService carService;
    private final ConstructorService constructorService;

    @Override
    public void createCar(CarRequest carRequest) {
        carService.save(carRequest);
    }

    @Override
    public void createConstructor(ConstructorRequest constructorRequest) {
        constructorService.createConstructor(constructorRequest);
    }
}
