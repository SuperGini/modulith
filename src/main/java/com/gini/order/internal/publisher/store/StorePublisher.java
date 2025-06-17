package com.gini.order.internal.publisher.store;

import com.gini.store.external.listeners.events.OrderPartRequestWrapperEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StorePublisher {

    private final ApplicationEventPublisher publisher;

    public void updatePartsInStore(OrderPartRequestWrapperEvent event) {
        publisher.publishEvent(event);
    }
}
