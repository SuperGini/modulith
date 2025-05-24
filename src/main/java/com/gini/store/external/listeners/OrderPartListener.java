package com.gini.store.external.listeners;

import com.gini.order.external.listeners.events.OrderPartRequestEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPartListener {

    @EventListener
    public void listenForPartsRequestsEvents(OrderPartRequestEvent event) {

    }

}
