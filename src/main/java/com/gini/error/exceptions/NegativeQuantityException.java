package com.gini.error.exceptions;

import org.springframework.modulith.NamedInterface;

@NamedInterface("negativeQuantityException")
public class NegativeQuantityException extends RuntimeException {

    public NegativeQuantityException(String message) {
        super(message);
    }
}
