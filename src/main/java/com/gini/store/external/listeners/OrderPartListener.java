package com.gini.store.external.listeners;

import com.gini.store.external.listeners.events.OrderPartRequestWrapperEvent;
import com.gini.store.internal.services.PartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
// @ApplicationModule(allowedDependencies = {"order::orderPartRequestEvent", "store"})
public class OrderPartListener {

    private final PartServiceImpl partService;

    @EventListener
    //    @ApplicationModuleListener
    //    @TransactionalEventListener
    public void listenForPartsRequestsEvents(OrderPartRequestWrapperEvent event) {
        partService.requestPartsFromStore(event.pertEvents());
    }
}
