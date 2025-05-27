package com.gini.car.internal.services;

import com.gini.car.external.api.generated.model.ConstructorRequest;
import com.gini.car.internal.domain.entities.Constructor;
import com.gini.car.internal.domain.repositories.ConstructorRepository;

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
