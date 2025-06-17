package com.gini.store.external.listeners.events;

import java.util.List;
import org.springframework.modulith.NamedInterface;

@NamedInterface("orderPartRequestWrapperEvent")
public record OrderPartRequestWrapperEvent(List<OrderPartRequestEvent> pertEvents) {}
