package com.gini.store.internal.services;

import com.gini.error.exceptions.NegativeQuantityException;
import com.gini.error.exceptions.NotFoundException;
import com.gini.store.external.api.generated.model.PartRequest;
import com.gini.store.external.api.generated.model.PartResponse;
import com.gini.store.external.api.generated.model.PartUpdateRequest;
import com.gini.store.external.interfaces.PartService;
import com.gini.store.external.listeners.events.OrderPartRequestEvent;
import com.gini.store.internal.domain.entities.Part;
import com.gini.store.internal.domain.repositories.PartRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    @Override
    public void createPart(PartRequest partRequest) {
        var part =
                Part.builder()
                        .name(partRequest.getName())
                        .partNumber(partRequest.getPartNumber())
                        .quantity(partRequest.getQuantity())
                        .build();

        partRepository.save(part);
    }

    @Transactional
    @Override
    public PartResponse findByPartNumber(String partNumber) {
        return partRepository
                .findByPartNumber(partNumber)
                .map(PartServiceImpl::maToPartResponse)
                .orElseThrow(() -> new NotFoundException("Part not found"));
    }

    @Transactional
    @Override
    public Part updatePartQuantity(PartUpdateRequest partUpdateRequest) {
        var part =
                partRepository
                        .findByPartNumber(partUpdateRequest.getPartNumber())
                        .orElseThrow(() -> new NotFoundException("Part not found"));

        var qty = part.getQuantity() + partUpdateRequest.getQuantity();
        part.setQuantity(qty);

        return partRepository.save(part);
    }

    @Transactional
    public void requestPartsFromStore(List<OrderPartRequestEvent> partsList) {

        partsList.forEach(
                partOrder -> {
                    var part =
                            partRepository
                                    .findByPartNumber(partOrder.partNumber())
                                    .orElseThrow(() -> new NotFoundException("Part not found"));

                    var qty = part.getQuantity() - partOrder.quantity();

                    if (qty < 0)
                        throw new NegativeQuantityException(
                                "Order quantity is bigger thant the parts in stock");

                    part.setQuantity(qty);
                    partRepository.save(part);
                });
    }

    private static PartResponse maToPartResponse(Part part) {
        return new PartResponse()
                .name(part.getName())
                .partNumber(part.getPartNumber())
                .quantity(part.getQuantity().toString());
    }
}
