package com.gini.store.external.interfaces;

import com.gini.store.external.api.generated.model.PartRequest;
import com.gini.store.external.api.generated.model.PartResponse;
import com.gini.store.external.api.generated.model.PartUpdateRequest;
import com.gini.store.internal.domain.entities.Part;
import org.springframework.modulith.NamedInterface;

@NamedInterface("patService")
public interface PartService {

    void createPart(PartRequest partRequest);

    PartResponse findByPartNumber(String partNumber);

    Part updatePartQuantity(PartUpdateRequest partUpdateRequest);
}
