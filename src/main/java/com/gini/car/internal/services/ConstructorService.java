package com.gini.car.internal.services;

import com.gini.car.internal.domain.entities.Constructor;
import com.gini.car.internal.domain.repositories.ConstructorRepository;
import com.gini.generated.car.model.ConstructorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConstructorService {

    private final ConstructorRepository constructorRepository;

    @Transactional
    public void createConstructor(ConstructorRequest constructorRequest) {
        var name = constructorRequest.getName();
        var constructor =  new Constructor();
        constructor.setName(name);
        constructorRepository.save(constructor);

    }

}
