package com.gini.store.external.listeners.events;

import org.springframework.modulith.NamedInterface;

@NamedInterface("orderPartResponse")
public record OrderPartResponse(String partNumber, Integer quantity) {}
