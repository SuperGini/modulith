package com.gini.store.external.api;

import com.gini.generated.car.api.StoreApi;
import com.gini.generated.car.model.PartRequest;
import com.gini.generated.car.model.PartResponse;
import com.gini.generated.car.model.PartUpdateRequest;
import com.gini.generated.car.model.PartUpdateResponse;
import com.gini.store.internal.services.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartController implements StoreApi {

    private final PartService partService;


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

        partService.updatePartQuantity(partUpdateRequest);




        return null;
    }
}
