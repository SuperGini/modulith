package com.gini.store.external.api.controllers;

import com.gini.car_module_openapi.api.StoreApi;
import com.gini.car_module_openapi.model.PartRequest;
import com.gini.car_module_openapi.model.PartResponse;
import com.gini.car_module_openapi.model.PartUpdateRequest;
import com.gini.car_module_openapi.model.PartUpdateResponse;
import com.gini.store.internal.services.PartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartController implements StoreApi {

    private final PartServiceImpl partService;

    @Override
    public void createPart(PartRequest partRequest) {
        partService.createPart(partRequest);
    }

    @Override
    public PartResponse getPart(String partNumber) {
        return partService.findByPartNumber(partNumber);
    }

    @Override
    public PartUpdateResponse updatePartQuantity(PartUpdateRequest partUpdateRequest) {

        var updatedPart = partService.updatePartQuantity(partUpdateRequest);

        return new PartUpdateResponse()
                .partNumber(updatedPart.getPartNumber())
                .name(updatedPart.getName())
                .quantity(updatedPart.getQuantity().toString());
    }
}
