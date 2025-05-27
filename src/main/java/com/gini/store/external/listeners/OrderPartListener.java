package com.gini.store.external.listeners;

import com.gini.store.external.listeners.events.OrderPartRequestEvent;
import com.gini.store.internal.services.PartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
//@ApplicationModule(allowedDependencies = {"order::orderPartRequestEvent", "store"})
public class OrderPartListener {

    private final PartServiceImpl partService;

    @EventListener
    public void listenForPartsRequestsEvents(List<OrderPartRequestEvent> partsRequestEvents) {
        partService.requestPartsFromStore(partsRequestEvents);
    }

}
