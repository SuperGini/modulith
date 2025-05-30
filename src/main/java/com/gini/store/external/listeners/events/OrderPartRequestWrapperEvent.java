package com.gini.store.external.listeners.events;

import org.springframework.modulith.NamedInterface;

import java.util.List;

@NamedInterface("orderPartRequestWrapperEvent")
public record OrderPartRequestWrapperEvent(
        List<OrderPartRequestEvent> pertEvents

) {
}
