package com.gini.order.external.listeners.events;

public record OrderPartRequestEvent(
        String partNumber,
        Integer quantity
) {
}
