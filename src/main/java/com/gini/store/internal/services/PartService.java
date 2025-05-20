package com.gini.store.internal.services;

import com.gini.generated.car.model.PartRequest;
import com.gini.generated.car.model.PartResponse;
import com.gini.generated.car.model.PartUpdateRequest;
import com.gini.store.internal.domain.entities.Part;
import com.gini.store.internal.domain.repositories.PartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartService {

    private final PartRepository partRepository;

    @Transactional
    public void createPart(PartRequest partRequest) {
        var part = Part.builder()
                .name(partRequest.getName())
                .partNumber(partRequest.getPartNumber())
                .quantity(partRequest.getQuantity())
                .build();

        partRepository.save(part);
    }

    @Transactional
    public PartResponse findByPartNumber(String partNumber) {
        return partRepository.findByPartNumber(partNumber)
                .map(PartService::maToPartResponse)
                .orElseThrow(() -> new RuntimeException("Part not found"));
    }


    @Transactional
    public void updatePartQuantity(PartUpdateRequest partUpdateRequest) {
        var part = partRepository.findByPartNumber(partUpdateRequest.getPartNumber())
                .orElseThrow(() -> new RuntimeException("Part not found"));

            var qty = part.getQuantity() + partUpdateRequest.getQuantity();
            part.setQuantity(qty);

            partRepository.save(part);
    }

    private static PartResponse maToPartResponse(Part part) {
        return new PartResponse()
                .name(part.getName())
                .partNumber(part.getPartNumber())
                .quantity(part.getQuantity().toString());
    }


}
