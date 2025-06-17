package com.gini.store.external.listeners.events;

import org.springframework.modulith.NamedInterface;

@NamedInterface("orderPartRequestEvent")
public record OrderPartRequestEvent(String partNumber, Integer quantity) {}
