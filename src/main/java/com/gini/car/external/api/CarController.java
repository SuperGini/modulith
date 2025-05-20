package com.gini.car.external.api;

import com.gini.car.internal.services.CarService;
import com.gini.car.internal.services.ConstructorService;
import com.gini.generated.car.api.CarApi;
import com.gini.generated.car.model.CarRequest;
import com.gini.generated.car.model.ConstructorRequest;
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
