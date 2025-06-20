package com.gini.store.external.interfaces;

import com.gini.car_module_openapi.model.PartRequest;
import com.gini.car_module_openapi.model.PartResponse;
import com.gini.car_module_openapi.model.PartUpdateRequest;
import com.gini.store.internal.domain.entities.Part;
import org.springframework.modulith.NamedInterface;

@NamedInterface("patService")
public interface PartService {

    void createPart(PartRequest partRequest);

    PartResponse findByPartNumber(String partNumber);

    Part updatePartQuantity(PartUpdateRequest partUpdateRequest);
}
