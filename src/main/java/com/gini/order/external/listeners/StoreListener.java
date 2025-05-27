package com.gini.order.external.listeners;


import com.gini.store.external.listeners.events.OrderPartResponse;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StoreListener {

    @EventListener
    private void updatePartQuantityResponse(OrderPartResponse event) {

    }

}
