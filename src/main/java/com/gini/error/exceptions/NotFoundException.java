package com.gini.error.exceptions;

import org.springframework.modulith.NamedInterface;

@NamedInterface("notFoundException")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
